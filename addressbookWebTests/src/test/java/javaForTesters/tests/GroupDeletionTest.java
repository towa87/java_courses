package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.groups().groupPage();
    if (app.groups().list().size() == 0)
    {
      app.groups().create(new GroupData().withName("test3"));
    }
  }
  @Test
  public void testDeletion() {
       List<GroupData> before = app.groups().list();
    int index = before.size()-1;
    app.groups().delete(index);
    List<GroupData> after = app.groups().list();

    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Assert.assertEquals(before, after);
  }


}
