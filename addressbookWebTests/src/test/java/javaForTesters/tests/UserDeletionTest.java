package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import javaForTesters.model.Accounts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Properties;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Антон on 23.08.2016.
 */
public class UserDeletionTest extends TestBase {
  @BeforeMethod
  public void ensureUserIsExcist(){
    app.goTo().homePage();

    if (app.db().accounts().size() == 0) {
      app.goTo().creationUserPage();
      app.user().createUser(new AccountCreation().withName("Ivan")
              .withLastname1("Smit").withNick("ST123").withNick("User")
              .withCompany("Software").withTelephoneHome("+474888822")
              .withEmail2("test@test2.com").withMobilePhone("+474888821")
              .withEmail3("test@test3.com").withWorkPhone("+474888821").withAddress("St.Ivanova")
              .withEmail("test@test.com").withHomepage("localhost:8080/").withPhoto(new File("src/test/resources/IMG_0012.PNG"))
              .withAyear("1990").withBirthday("2000").withGroup("test3"), true);
      app.goTo().homePage();
    }
  }
  @Test
  public void userDeletionTest() {
     Accounts before = app.db().accounts();
    AccountCreation deletedUser = before.iterator().next();

    app.user().delete(deletedUser);
    app.goTo().homePage();
    assertThat(before.size()-1, equalTo(app.user().count()));
    Accounts  after = app.db().accounts();



    assertThat(after, equalTo(before.without(deletedUser)));


  }


}