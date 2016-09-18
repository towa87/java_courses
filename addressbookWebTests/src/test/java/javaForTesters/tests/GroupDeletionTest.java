package javaForTesters.tests;

import javaForTesters.model.GroupData;
import javaForTesters.model.Groups;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
       Groups before = app.groups().all();
    GroupData deletedGroup = before.iterator().next();
        app.groups().delete(deletedGroup);
    assertThat(app.groups().count(),equalTo(before.size() - 1));
    Groups after = app.groups().all();



     MatcherAssert.assertThat(after, equalTo(before.without(deletedGroup)));

  }


}
