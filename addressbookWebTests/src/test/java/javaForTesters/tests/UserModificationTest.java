package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import javaForTesters.model.Accounts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Антон on 23.08.2016.
 */
public class UserModificationTest extends TestBase {
  @BeforeMethod
  public void ensureUserIsExcist() {
    app.goTo().homePage();

    if (!app.user().isThereUser()) {
      app.goTo().creationUserPage();
      app.user().createUser(new AccountCreation().withName("Ivan")
                      .withLastname1("Smit").withNick("ST123").withNick("User")
                      .withCompany("Software").withTelephoneHome("+4704888822")
                      .withTelephoneHome2("+4704888822").withMobilePhone("+4704888821")
                      .withMobilePhone2("+4704888821").withWorkPhone("+4704888821").withWorkPhone2("+4704888827")
                      .withWorkPhone3("+4704888829").withEmail("test@test.com").withHomepage("localhost:8080/")
                      .withAyear("1990").withBirthday("2000"), true);


              app.goTo().homePage();
    }
  }


  @Test
  public void testModificationUser() {
    Accounts before = app.user().userList();

    AccountCreation modifiedUser = before.iterator().next();

    AccountCreation user = new AccountCreation().withId(modifiedUser.getId()).withName("Ivan")
            .withLastname1("Smit").withNick("ST123").withNick("User")
            .withCompany("Software").withTelephoneHome("+4704888822")
            .withTelephoneHome2("+4704888822").withMobilePhone("+4704888821")
            .withMobilePhone2("+4704888821").withWorkPhone("+4704888821").withWorkPhone2("+4704888827")
            .withWorkPhone3("+4704888829").withEmail("test@test.com").withHomepage("localhost:8080/")
            .withAyear("1990").withBirthday("2000");
    app.user().modify(user);
    app.goTo().homePage();
    Accounts after = app.user().userList();

    assertThat(before.size(), equalTo(after.size()));

    assertThat(after, equalTo(before.without(modifiedUser).withAdded(modifiedUser)));


  }


}