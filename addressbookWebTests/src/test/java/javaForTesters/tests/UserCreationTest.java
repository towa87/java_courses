package javaForTesters.tests;

import com.sun.jna.platform.win32.Advapi32Util;
import javaForTesters.model.AccountCreation;
import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class UserCreationTest extends TestBase {

  @Test

  public void testUserCreation() {
    //app.getNavigationHelper().goToHomePage();
    List<AccountCreation> before = app.getUserHelper().getUserList();
    app.getNavigationHelper().goToCreationUserPage();
    AccountCreation account = new AccountCreation("Ivan", "Smit", "ST123", "User", "Software", "+4704888822", "+4704888822", "+4704888821", "+4704888821", "+4704888821", "+4704888827", "+4704888829", "test@test.com", "localhost:8080/", "1990", "2000", "test3");
    app.getUserHelper().createUser(account, true);
    app.getNavigationHelper().goToHomePage();
    List<AccountCreation> after = app.getUserHelper().getUserList();

/*
    account.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
*/
  }

}
