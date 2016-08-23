package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by Антон on 23.08.2016.
 */
public class UserDeletionTest extends TestBase {

  @Test
  public void userDeletionTest() {
    app.getNavigationHelper().goToHomePage();
    app.getUserHelper().editUser();
    app.getUserHelper().deleteUserButton();
    app.getNavigationHelper().goToListOfUsersPage();
  }
}