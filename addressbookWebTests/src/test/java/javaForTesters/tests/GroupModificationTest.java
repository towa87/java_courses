package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by Антон on 22.08.2016.
 */
public class GroupModificationTest extends TestBase {
  @BeforeMethod
public void ensurePreconditions(){
    app.groups().groupPage();
    if (app.groups().all().size() == 0)
    {

      app.groups().create(new GroupData().withName("test3"));
    }
  }

  @Test
  public void testModifiction() {

    Set<GroupData> before = app.groups().all();

    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId())
            .withName("testmodified3").setFooter("test5").withHeader("test6");

    app.groups().modify(group);
    Set<GroupData> after = app.groups().all();
    Assert.assertEquals(before.size(), after.size());
    before.remove(modifiedGroup);
    before.add(group);



    Assert.assertEquals(after, before);
  }


}
