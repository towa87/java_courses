package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import javaForTesters.model.Accounts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreationTest extends TestBase {

  @Test
  public void testUserCreation() {
    app.goTo().homePage();
    Accounts before = app.user().userList();
    app.goTo().creationUserPage();
    File photo = new File("addressbookWebTests/src/test/resources/test.png");
    AccountCreation account = new AccountCreation().withName("Ivan")
            .withLastname1("Smit").withNick("ST123").withNick("User")
            .withCompany("Software").withTelephoneHome("+474888822")
            .withEmail2("test@test2.com").withMobilePhone("+474888821")
            .withEmail3("test@test3.com").withWorkPhone("+474888821").withAddress("St.Ivanova")
            .withEmail("test@test.com").withHomepage("localhost:8080/")
            .withAyear("1990").withBirthday("2000").withGroup("test3").withPhoto(photo);
    app.user().createUser(account, true);
    app.goTo().homePage();
    assertThat(app.user().count(), equalTo(before.size() + 1));
    Accounts after = app.user().userList();

    //assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before.withAdded(account.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testBadUserCreation() {
    app.goTo().homePage();
    Accounts before = app.user().userList();
    app.goTo().creationUserPage();
    File photo = new File("src/test/resources/IMG_0012.PNG");
    AccountCreation account = new AccountCreation().withName("Ivan'''")
            .withLastname1("Smit''").withNick("ST123").withNick("User''")
            .withCompany("Software").withTelephoneHome("+474888822")
            .withEmail2("Test@test2.com").withMobilePhone("+47888821")
            .withEmail3("Test@test3.com").withWorkPhone("+474888821").withAddress("St.Ivanova")
            .withEmail("test@test.com").withHomepage("localhost:8080/")
            .withGroup("test3").withPhoto(photo);
    app.user().createUser(account, true);
    app.goTo().homePage();
    assertThat(app.user().count(), equalTo(before.size()));
    Accounts after = app.user().userList();

    //assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before));
  }



  /*@Test
public void testUserCreationa() {
    File cur = new File(".");
    System.out.println(cur.getAbsolutePath());
}*/
}
