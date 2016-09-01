package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testDeletion() {
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupsHelper().isThereGroup())
    {

      app.getGroupsHelper().createGroup(new GroupData("test3", null, null));
    }
    app.getGroupsHelper().selectGroup();
    app.getGroupsHelper().deleteSelectedGroup();
    app.getNavigationHelper().goToGroupPage();
  }
}
