package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before = app.getGroupsHelper().getGroupList();
    app.getGroupsHelper().initGroupCreation();
    app.getGroupsHelper().populateFieldsOfGroupForm(new GroupData("test3", null, "test6"));
    app.getGroupsHelper().submitGroupCreation();
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> after = app.getGroupsHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
