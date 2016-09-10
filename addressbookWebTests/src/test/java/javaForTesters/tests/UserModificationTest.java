package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
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
    AccountCreation user = new AccountCreation(before.get(0).getId(), "Filip", "Sidorov", "ST123", "User", "Software", "+4704888822", "+4704888822", "+4704888821", "+4704888821", "+4704888821", "+4704888827", "+4704888829", "test@test.com", "localhost:8080/", "1990", "2000", null);
    app.getUserHelper().populationNewUserForm(user, false);
    app.getUserHelper().editUserButton();
    app.getNavigationHelper().goToHomePage();
    List<AccountCreation> after = app.getUserHelper().getUserList();
    Assert.assertEquals(before.size(), after.size());
    before.remove(0);
    before.add(user);


    Comparator<? super AccountCreation> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);


  }
}