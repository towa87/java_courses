package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import org.testng.annotations.Test;

public class UserCreationTest extends TestBase {

  @Test
  public void testUserCreation() {

    app.getNavigationHelper().goToCreationUserPage();
    app.getUserHelper().populationNewUserForm(new AccountCreation("Ivan", "Smit", "ST123", "User", "Software", "+4704888822", "+4704888822", "+4704888821", "+4704888821", "+4704888821", "+4704888827", "+4704888829", "test@test.com", "localhost:8080/", "1990", "2000", "test3"), true);
    app.getUserHelper().submitCreationNewUserRecord();
    app.getNavigationHelper().goToListOfUsersPage();

  }

}
