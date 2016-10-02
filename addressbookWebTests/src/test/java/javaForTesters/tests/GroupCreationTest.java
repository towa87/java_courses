package javaForTesters.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import javaForTesters.model.GroupData;
import javaForTesters.model.Groups;
import org.jboss.netty.logging.Slf4JLoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

@DataProvider
public Iterator<Object[]> validGroupsFromXml() throws IOException {
  List<Object[]> list = new ArrayList<Object[]>();
  BufferedReader reader = new BufferedReader(new FileReader(new File("addressbookWebTests/src/test/resources/groups.xml")));
  String xml = "";
  String line = reader.readLine();
  while (line != null)
  {
    xml+=line;
    line = reader.readLine();
  }
XStream xStream = new XStream();
  xStream.processAnnotations(GroupData.class);
  List<GroupData> groups =(List<GroupData>) xStream.fromXML(xml);
return groups.stream().map((g)->new Object[] {g}).collect(Collectors.toList()).iterator();
     }
  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("addressbookWebTests/src/test/resources/groups.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null)
    {
      json+=line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType());//List<GroupData>.class

    return groups.stream().map((g)->new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validGroupsFromJson")
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
