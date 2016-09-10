package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testDeletion() {
    app.getNavigationHelper().goToGroupPage();

    if (! app.getGroupsHelper().isThereGroup())
    {

      app.getGroupsHelper().createGroup(new GroupData("test3", null, null));

    }
    List<GroupData> before = app.getGroupsHelper().getGroupList();
    app.getGroupsHelper().selectGroup(before.size()-1);
    app.getGroupsHelper().deleteSelectedGroup();
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> after = app.getGroupsHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() -1);
    Assert.assertEquals(before, after);
  }
}
