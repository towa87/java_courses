package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Антон on 22.08.2016.
 */
public class GroupModificationTest extends TestBase {
  @BeforeMethod
public void ensurePreconditions(){
    app.groups().groupPage();
    if (app.groups().list().size() == 0)
    {

      app.groups().create(new GroupData().withName("test3"));
    }
  }

  @Test
  public void testModifiction() {

    List<GroupData> before = app.groups().list();
    int index = before.size() - 1;
    GroupData group = new GroupData().withId(before.get(index).getId())
            .withName("testmodified3").setFooter("test5").withHeader("test6");

    app.groups().modify(index, group);
    List<GroupData> after = app.groups().list();
    Assert.assertEquals(before.size(), after.size());
    before.remove(index);
    before.add(group);


    Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
  }


}
