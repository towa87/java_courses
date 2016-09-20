package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
              .withLastname1("Smit").withNick("ST123").withNick("User")
              .withCompany("Software").withTelephoneHome("+4704888822")
              .withMobilePhone("+4704888821").withWorkPhone("+4704888821")
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
    assertThat(account.getTelephoneHome(), equalTo(cleaned(accountInforFromEditForm.getTelephoneHome())));
    assertThat(account.getWorkPhone(), equalTo(cleaned(accountInforFromEditForm.getWorkPhone())));
    assertThat(account.getMobilePhone(), equalTo(cleaned(accountInforFromEditForm.getMobilePhone())));
    assertThat(account.getEmail(), equalTo(accountInforFromEditForm.getEmail()));
    assertThat(account.getEmail2(), equalTo(accountInforFromEditForm.getEmail2()));
    assertThat(account.getEmail3(), equalTo(accountInforFromEditForm.getEmail3()));
    assertThat(account.getAddress(), equalTo(accountInforFromEditForm.getAddress()));
  }
    public String cleaned (String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");

  }
}
