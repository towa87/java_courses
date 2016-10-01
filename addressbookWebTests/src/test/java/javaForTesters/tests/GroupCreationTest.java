package javaForTesters.tests;

import javaForTesters.model.GroupData;
import javaForTesters.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {
@DataProvider
public Iterator<Object[]> validGroups() throws IOException {
  List<Object[]> list = new ArrayList<Object[]>();
  BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
  String line = reader.readLine();
  while (line != null)
  {
    String[] split = line.split(";");
    list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
    line = reader.readLine();
  }

return list.iterator();
}
  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {

    app.groups().groupPage();
    Groups before = app.groups().all();
  // GroupData group = new GroupData().withName("test3");
    app.groups().create(group);
    app.groups().groupPage();
    assertThat(app.groups().count(),equalTo(before.size() + 1));
    Groups after = app.groups().all();
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }
  @Test(enabled = false)
  public void testBadGroupCreation() {

    app.groups().groupPage();
    Groups before = app.groups().all();

    GroupData group = new GroupData().withName("test3'");
    app.groups().create(group);
    app.groups().groupPage();
    assertThat(app.groups().count(),equalTo(before.size()));
    Groups after = app.groups().all();



    assertThat(after, equalTo(before));
  }
}
