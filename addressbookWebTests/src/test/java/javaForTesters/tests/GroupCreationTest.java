package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.groups().groupPage();
    List<GroupData> before = app.groups().list();

   GroupData group = new GroupData().withName("test3");
    app.groups().create(group);
    app.groups().groupPage();
    List<GroupData> after = app.groups().list();
    Assert.assertEquals(after.size(), before.size() + 1);

   // group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
  }

}
