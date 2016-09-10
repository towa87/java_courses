package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class UserCreationTest extends TestBase {

  @Test
  public void testUserCreation() {
    app.getNavigationHelper().goToGroupPage();
    List<AccountCreation> before = app.getUserHelper().getUserList();

    GroupData group = new GroupData("test3", null, "test6");
    app.getGroupsHelper().createGroup(group);
    app.getNavigationHelper().goToGroupPage();
    List<AccountCreation> after = app.getUserHelper().getUserList();

/*
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
    */
  }

}
