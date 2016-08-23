package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by Антон on 23.08.2016.
 */
public class UserModificationTest extends TestBase {
  @Test
  public void testModificationUser(){
app.getNavigationHelper().goToHomePage();
    app.getUserHelper().editUser();
    app.getUserHelper().populationNewUserForm(new AccountCreation("Ivan", "Smits", "ST123s", "User", "Software", "+4704888822", "+4704888822", "+4704888821", "+4704888821", "+4704888821", "+4704888827", "+4704888829", "test@test.com", "localhost:8080/", "1990", "2000"));
    app.getUserHelper().editUserButton();
    app.getNavigationHelper().goToListOfUsersPage();
  }
}