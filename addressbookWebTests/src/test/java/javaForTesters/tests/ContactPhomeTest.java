package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Антон on 19.09.2016.
 */
public class ContactPhomeTest extends TestBase{
  @BeforeMethod
  public void ensureUserIsExcist(){
    app.goTo().homePage();

    if (!app.user().isThereUser()) {
      app.goTo().creationUserPage();
      app.user().createUser(new AccountCreation().withName("Ivan")
              .withLastname1("Smit").withNick("ST123")
              .withCompany("Software").withTelephoneHome("+474888822")
              .withMobilePhone("+474888821").withWorkPhone("+474888821")
              .withEmail("test@test.com").withHomepage("localhost:8080/")
              .withAyear("1990").withBirthday("2000").withGroup("test3"), true);
      app.goTo().homePage();
    }
  }
  @Test
  public void testContactPhones() {
    app.goTo().homePage();
    AccountCreation account = app.user().userList().iterator().next();
    AccountCreation accountInforFromEditForm = app.user().infoFromEditForm(account);
    assertThat(account.getAllPhone(), equalTo(mergePhones(accountInforFromEditForm)));
    assertThat(account.getAllEmails(), equalTo(mergeEmails(accountInforFromEditForm)));

    assertThat(account.getAddress(), equalTo(accountInforFromEditForm.getAddress()));
  }

  private String mergeEmails(AccountCreation account) {
    return Arrays.asList(account.getEmail(), account.getEmail2(), account.getEmail3())
            .stream().filter((s) -> ! s.equals("") )
            .collect(Collectors.joining("\n"));
  }


  private String  mergePhones(AccountCreation account) {
    return Arrays.asList(account.getTelephoneHome(), account.getMobilePhone(), account.getWorkPhone())
            .stream().filter((s) -> ! s.equals("")).map(ContactPhomeTest::cleaned)
            .collect(Collectors.joining("\n"));

  }

  public static String cleaned (String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");

  }
}
