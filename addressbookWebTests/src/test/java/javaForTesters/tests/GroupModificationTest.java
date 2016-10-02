package javaForTesters.tests;

import javaForTesters.model.GroupData;
import javaForTesters.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Properties;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

    Groups before = app.groups().all();

    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId())
            .withName("testmodified3").withFooter("test5").withHeader("test6");

    app.groups().modify(group);
    assertThat(app.groups().count(),equalTo(before.size()));

    Groups after = app.groups().all();
       assertThat(after,equalTo(before.without(modifiedGroup).withAdded(group)));

  }


}
