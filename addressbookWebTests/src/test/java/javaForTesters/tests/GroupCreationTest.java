package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupsHelper().getGroupCount();
    app.getGroupsHelper().initGroupCreation();
    app.getGroupsHelper().populateFieldsOfGroupForm(new GroupData("test3", null, "test6"));
    app.getGroupsHelper().submitGroupCreation();
    app.getNavigationHelper().goToGroupPage();
    int after = app.getGroupsHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }

}
