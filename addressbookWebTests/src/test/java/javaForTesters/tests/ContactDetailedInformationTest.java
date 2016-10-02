package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Properties;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Антон on 21.09.2016.
 */
public class ContactDetailedInformationTest extends TestBase{
  @BeforeMethod
  public void ensureUserIsExcist(){
    app.goTo().homePage();

    if (!app.user().isThereUser()) {
      app.goTo().creationUserPage();
      app.user().createUser(new AccountCreation().withName("Ivan")
              .withLastname1("Smit").withAddress("My street").withTelephoneHome("+474888822")
              .withMobilePhone("+474888821").withWorkPhone("+474888821")
              .withEmail("test1@test.com").withEmail2("test2@test.com").withEmail3("test3@test.com"));
      app.goTo().homePage();
    }
  }
  @Test
  public void testContactDetailedInformation() {

    app.goTo().homePage();
    AccountCreation account = app.user().userList().iterator().next();
    AccountCreation accountInforFromEditForm = app.user().infoFromEditForm(account);
    app.goTo().detailsUser(account.getId());
   String detailedData = app.user().detailedUserData();

   String dataFromHomePage = detailedData.replaceAll((("[()]|H:|M:|W:|\n|\\s|(www.test.com)")), "");



    assertThat(dataFromHomePage, equalTo(mergeUserData(accountInforFromEditForm)));

  }

  private String mergeUserData(AccountCreation account) {
    return Arrays.asList(account.getName(), account.getLastname(),
            account.getAddress(), account.getTelephoneHome(), account.getMobilePhone(),
            account.getWorkPhone(), account.getEmail(), account.getEmail2(), account.getEmail3())
            .stream().filter((s) -> ! s.equals("") ).map(ContactDetailedInformationTest::cleaned)
            .collect(Collectors.joining(""));
  }

  public static String cleaned (String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()|\n]", "");

  }}
