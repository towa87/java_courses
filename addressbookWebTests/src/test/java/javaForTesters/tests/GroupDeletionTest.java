package javaForTesters.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {


  @Test
  public void testDeletion() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupsHelper().selectGroup();
    app.getGroupsHelper().deleteSelectedGroup();
    app.getNavigationHelper().goToGroupPage();

  }


}
