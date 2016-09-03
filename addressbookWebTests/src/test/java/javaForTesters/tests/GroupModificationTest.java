package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Антон on 22.08.2016.
 */
public class GroupModificationTest extends TestBase {
  @Test
  public void testModifiction() {
    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupsHelper().getGroupCount();
    if (! app.getGroupsHelper().isThereGroup())
    {

      app.getGroupsHelper().createGroup(new GroupData("test3", null, null));
    }
    app.getGroupsHelper().selectGroup();
    app.getNavigationHelper().initGroupModification();
    app.getGroupsHelper().populateFieldsOfGroupForm(new GroupData("testmodified3", "test5", "test6"));
    app.getGroupsHelper().submitGroupModification();
    app.getGroupsHelper().navigateToGroupCreation();
    int after = app.getGroupsHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
