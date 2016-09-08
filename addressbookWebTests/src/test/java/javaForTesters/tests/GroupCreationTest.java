package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before = app.getGroupsHelper().getGroupList();
    app.getGroupsHelper().initGroupCreation();
    GroupData group = new GroupData("test3", null, "test6");
    app.getGroupsHelper().populateFieldsOfGroupForm(group);
    app.getGroupsHelper().submitGroupCreation();
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> after = app.getGroupsHelper().getGroupList();


    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Assert.assertEquals(new HashSet<>(after), new HashSet<>(before));
  }

}
