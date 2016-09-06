package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Антон on 22.08.2016.
 */
public class GroupModificationTest extends TestBase {
  @Test
  public void testModifiction() {
    app.getNavigationHelper().goToGroupPage();
       if (! app.getGroupsHelper().isThereGroup())
    {

      app.getGroupsHelper().createGroup(new GroupData("test3", null, null));
    }
    List<GroupData> before = app.getGroupsHelper().getGroupList();
    app.getGroupsHelper().selectGroup(0);
    app.getNavigationHelper().initGroupModification();
    GroupData group = new GroupData(before.get(0).getId(), "testmodified3", "test5", "test6");
    app.getGroupsHelper().populateFieldsOfGroupForm(group);
    app.getGroupsHelper().submitGroupModification();
    app.getGroupsHelper().navigateToGroupCreation();
    List<GroupData> after = app.getGroupsHelper().getGroupList();
before.remove(0);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));
  }
}
