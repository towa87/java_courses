package javaForTesters.tests;

import javaForTesters.model.GroupData;
import javaForTesters.model.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.groups().groupPage();
    Groups before = app.groups().all();

   GroupData group = new GroupData().withName("test3");
    app.groups().create(group);
    app.groups().groupPage();
    Groups after = app.groups().all();
    assertThat(after.size(),equalTo(before.size() + 1));


    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }

}
