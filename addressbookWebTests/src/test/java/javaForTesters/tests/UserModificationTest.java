package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import javaForTesters.model.Accounts;
import javaForTesters.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Properties;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Антон on 23.08.2016.
 */
public class UserModificationTest extends TestBase {
  @BeforeMethod
  public void ensureUserIsExcist() {
    if (app.db().accounts().size() == 0) {
      Groups groups = app.db().groups();
      app.goTo().creationUserPage();
      app.user().createUser(new AccountCreation().withName("Ivan")
              .withLastname1("Smit").withNick("ST123").withNick("User")
              .withCompany("Software").withTelephoneHome("+474888822")
              .withEmail2("test@test2.com").withMobilePhone("+474888821")
              .withEmail3("test@test3.com").withWorkPhone("+474888821").withAddress("St.Ivanova")
              .withEmail("test@test.com").withHomepage("localhost:8080/").withPhoto(new File("src/test/resources/IMG_0012.PNG"))
              .withAyear("1990").withBirthday("2000")
              .inGroup(groups.iterator().next()), true);
              app.goTo().homePage();
    }
  }


  @Test
  public void testModificationUser() {
    Accounts before = app.db().accounts();

    AccountCreation modifiedUser = before.iterator().next();
    Groups groups = app.db().groups();
    AccountCreation user = new AccountCreation().withId(modifiedUser.getId()).withName("Ivan")
            .withLastname1("Smit").withNick("ST123").withNick("User")
            .withCompany("Software").withTelephoneHome("+474888822")
            .withEmail2("test@test2.com").withMobilePhone("+474888821")
            .withEmail3("test@test3.com").withWorkPhone("+474888821").withAddress("St.Ivanova")
            .withEmail("test@test.com").withHomepage("localhost:8080/")
            .withAyear("1990").withBirthday("2000").withPhoto(new File("src/test/resources/IMG_0012.PNG"))
    .inGroup(groups.iterator().next());

    app.user().modify(user);
    app.goTo().homePage();
    Accounts after = app.db().accounts();

    assertThat(before.size(), equalTo((app.user().count())));

    assertThat(after, equalTo(before.without(modifiedUser).withAdded(user)));
    verifyAccountListInUI();

  }


}