package javaForTesters.tests;

import com.thoughtworks.xstream.XStream;
import javaForTesters.model.AccountCreation;
import javaForTesters.model.Accounts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Properties;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreationTest extends TestBase {



  @DataProvider
  public Iterator<Object[]> validAccountsFromXml() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/accounts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null)
    {
      xml+=line;
      line = reader.readLine();
    }
    XStream xStream = new XStream();
    xStream.processAnnotations(AccountCreation.class);
    List<AccountCreation> accounts =(List<AccountCreation>) xStream.fromXML(xml);
    return accounts.stream().map((g)->new Object[] {g}).collect(Collectors.toList()).iterator();
  }
  @Test(dataProvider = "validAccountsFromXml")
  public void testUserCreation(AccountCreation account) {

    app.goTo().homePage();
    Accounts before = app.user().userList();
    app.goTo().creationUserPage();

    app.user().createUser(account, true);
    app.goTo().homePage();
    assertThat(app.user().count(), equalTo(before.size() + 1));
    Accounts after = app.user().userList();

      assertThat(after, equalTo(before.withAdded(account.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

  @Test(enabled = false)
  public void testBadUserCreation() {
    app.goTo().homePage();
    Accounts before = app.db().accounts();
    app.goTo().creationUserPage();
    File photo = new File("src/test/resources/IMG_0012.PNG");
    AccountCreation account = new AccountCreation().withName("Ivan'''")
            .withLastname1("Smit''").withNick("ST123").withNick("User''")
            .withCompany("Software").withTelephoneHome("+474888822")
            .withEmail2("Test@test2.com").withMobilePhone("+47888821")
            .withEmail3("Test@test3.com").withWorkPhone("+474888821").withAddress("St.Ivanova")
            .withEmail("test@test.com").withHomepage("localhost:8080/")
            .withGroup("test3").withPhoto(photo);
    app.user().createUser(account, true);
    app.goTo().homePage();
    assertThat(app.user().count(), equalTo(before.size()));
    Accounts after = app.db().accounts();

    //assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before));
  }



  /*@Test
public void testUserCreationa() {
    File cur = new File(".");
    System.out.println(cur.getAbsolutePath());
}*/
}
