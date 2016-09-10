package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import javaForTesters.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Антон on 23.08.2016.
 */
public class UserModificationTest extends TestBase {
  @Test
  public void testModificationUser() {
    app.getNavigationHelper().goToHomePage();

    if (!app.getUserHelper().isThereUser()) {
      app.getNavigationHelper().goToCreationUserPage();
      app.getUserHelper().createUser(new AccountCreation("Ivan", "Smit", "ST123", "User", "Software", "+4704888822", "+4704888822", "+4704888821", "+4704888821", "+4704888821", "+4704888827", "+4704888829", "test@test.com", "localhost:8080/", "1990", "2000", "test3"), true);
      app.getNavigationHelper().goToHomePage();
    }
    List<AccountCreation> before = app.getUserHelper().getUserList();
    app.getUserHelper().editUser(0);
    app.getUserHelper().populationNewUserForm(new AccountCreation("Filip", "Sidorov", "ST123", "User", "Software", "+4704888822", "+4704888822", "+4704888821", "+4704888821", "+4704888821", "+4704888827", "+4704888829", "test@test.com", "localhost:8080/", "1990", "2000", null), false);
    app.getUserHelper().editUserButton();
    app.getNavigationHelper().goToHomePage();
    List<AccountCreation> after = app.getUserHelper().getUserList();
    Assert.assertEquals(before.size(), after.size());
  }
}