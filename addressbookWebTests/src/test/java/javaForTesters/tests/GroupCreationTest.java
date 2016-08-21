package javaForTesters.tests;


import javaForTesters.model.GroupData;
import org.testng.annotations.Test;



public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.getNavigationHelper().goToGroupPage();
    app.getGroupsHelper().initGroupCreation();
    app.getGroupsHelper().populateFieldsOfGroupForm(new GroupData("test3", "test5", "test6"));
    app.getGroupsHelper().submitGroupCreation();
  }

}
