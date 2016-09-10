package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
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
    Assert.assertEquals(before.size(), after.size());
    before.remove(0);
    before.add(group);


    Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
  }
}
