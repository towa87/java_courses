package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import javaForTesters.model.Accounts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreationTest extends TestBase {

  @Test

  public void testUserCreation() {
    app.goTo().homePage();
    Accounts before = app.user().userList();
    app.goTo().creationUserPage();
    AccountCreation account = new AccountCreation().withName("Ivan")
            .withLastname1("Smit").withNick("ST123").withNick("User")
            .withCompany("Software").withTelephoneHome("+4704888822")
            .withEmail2("test@test2.com").withMobilePhone("+4704888821")
            .withEmail3("test@test3.com").withWorkPhone("+4704888821").withAddress("St.Ivanova")
            .withEmail("test@test.com").withHomepage("localhost:8080/")
            .withAyear("1990").withBirthday("2000").withGroup("test3");
    app.user().createUser(account, true);
    app.goTo().homePage();
    assertThat(app.user().count(), equalTo(before.size() + 1));
    Accounts after = app.user().userList();

    //assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before.withAdded(account.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
  public void testBadUserCreation() {
    app.goTo().homePage();
    Accounts before = app.user().userList();
    app.goTo().creationUserPage();
    AccountCreation account = new AccountCreation().withName("Ivan'''")
            .withLastname1("Smit''").withNick("ST123").withNick("User''")
            .withCompany("Software").withTelephoneHome("+4704888822")
            .withEmail2("Test@test2.com").withMobilePhone("+4704888821")
            .withEmail3("Test@test3.com").withWorkPhone("+4704888821").withAddress("St.Ivanova")
            .withEmail("test@test.com").withHomepage("localhost:8080/")
            .withAyear("1990").withBirthday("2000").withGroup("test3");
    app.user().createUser(account, true);
    app.goTo().homePage();
    assertThat(app.user().count(), equalTo(before.size()));
    Accounts after = app.user().userList();

    //assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before.withAdded(account.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
