package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by Антон on 23.08.2016.
 */
public class UserDeletionTest extends TestBase {
  @BeforeMethod
  public void ensureUserIsExcist(){
    app.goTo().homePage();

    if (!app.user().isThereUser()) {
      app.goTo().creationUserPage();
      app.user().createUser(new AccountCreation().withName("Ivan")
              .withLastname1("Smit").withNick("ST123").withNick("User")
              .withCompany("Software").withTelephoneHome("+4704888822")
              .withTelephoneHome2("+4704888822").withMobilePhone("+4704888821")
              .withMobilePhone2("+4704888821").withWorkPhone("+4704888821").withWorkPhone2("+4704888827")
              .withWorkPhone3("+4704888829").withEmail("test@test.com").withHomepage("localhost:8080/")
              .withAyear("1990").withBirthday("2000").withGroup("test3"), true);
      app.goTo().homePage();
    }
  }
  @Test
  public void userDeletionTest() {
     Set<AccountCreation> before = app.user().userList();
    AccountCreation deletedUser = before.iterator().next();
    int index = before.size() - 1;
    app.user().delete(deletedUser);
    app.goTo().homePage();
    Set<AccountCreation> after = app.user().userList();
    Assert.assertEquals(before.size()-1, after.size());


    before.remove(deletedUser);
    Assert.assertEquals(before, after);

  }


}