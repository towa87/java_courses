package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.groups().groupPage();
    if (app.groups().all().size() == 0)
    {
      app.groups().create(new GroupData().withName("test3"));
    }
  }
  @Test
  public void testDeletion() {
       Set<GroupData> before = app.groups().all();
    GroupData deletedGroup = before.iterator().next();
        app.groups().delete(deletedGroup);
    Set<GroupData> after = app.groups().all();

    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(deletedGroup);
    Assert.assertEquals(before, after);
  }


}
