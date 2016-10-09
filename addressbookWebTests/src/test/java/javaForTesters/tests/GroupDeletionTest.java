package javaForTesters.tests;

import javaForTesters.model.GroupData;
import javaForTesters.model.Groups;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Properties;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.groups().groupPage();
      app.groups().create(new GroupData().withName("test3"));
    }
  }

  @Test
  public void testDeletion() {
       Groups before = app.db().groups();

    GroupData deletedGroup = before.iterator().next();
    app.groups().groupPage();
        app.groups().delete(deletedGroup);
    assertThat(app.groups().count(),equalTo(before.size() - 1));
    Groups after = app.db().groups();
     MatcherAssert.assertThat(after, equalTo(before.without(deletedGroup)));
    verifyGroupListInUI();
  }


}
