package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Антон on 23.08.2016.
 */
public class UserDeletionTest extends TestBase {

  @Test
  public void userDeletionTest() {
    app.getNavigationHelper().goToHomePage();


    if (!app.getUserHelper().isThereUser()) {
      app.getNavigationHelper().goToCreationUserPage();
      app.getUserHelper().createUser(new AccountCreation("Ivan", "Smit", "ST123", "User", "Software", "+4704888822", "+4704888822", "+4704888821", "+4704888821", "+4704888821", "+4704888827", "+4704888829", "test@test.com", "localhost:8080/", "1990", "2000", "test3"), true);
      app.getNavigationHelper().goToHomePage();
    }

    List<AccountCreation> before = app.getUserHelper().getUserList();
    app.getUserHelper().editUser();
    app.getUserHelper().deleteUserButton();
    app.getNavigationHelper().goToHomePage();
    List<AccountCreation> after = app.getUserHelper().getUserList();
    Assert.assertEquals(before.size()-1, after.size());
    before.remove(before.size() -1);
    Assert.assertEquals(before, after);

  }
}