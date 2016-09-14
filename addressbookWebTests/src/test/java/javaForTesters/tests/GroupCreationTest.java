package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.groups().groupPage();
    Set<GroupData> before = app.groups().all();

   GroupData group = new GroupData().withName("test3");
    app.groups().create(group);
    app.groups().groupPage();
    Set<GroupData> after = app.groups().all();
    Assert.assertEquals(after.size(), before.size() + 1);
group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
   // group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Assert.assertEquals(after, before);
  }

}
