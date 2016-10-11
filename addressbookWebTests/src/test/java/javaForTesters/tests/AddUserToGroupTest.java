package javaForTesters.tests;

import com.thoughtworks.xstream.XStream;
import javaForTesters.model.AccountCreation;
import javaForTesters.model.Accounts;
import javaForTesters.model.GroupData;
import javaForTesters.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Антон on 10.10.2016.
 */

public class AddUserToGroupTest extends TestBase {

  @BeforeMethod
  public void ensureUserAndGroupIsExcist() {
    app.goTo().homePage();

    if (app.db().accounts().size() == 0) {
      app.goTo().creationUserPage();
      app.user().createUser(new AccountCreation().withName("Ivan")
              .withLastname1("Smit").withNick("ST123").withNick("User")
              .withCompany("Software").withTelephoneHome("+474888822")
              .withEmail2("test@test2.com").withMobilePhone("+474888821")
              .withEmail3("test@test3.com").withWorkPhone("+474888821").withAddress("St.Ivanova")
              .withEmail("test@test.com").withHomepage("localhost:8080/").withPhoto(new File("src/test/resources/IMG_0012.PNG"))
              .withAyear("1990").withBirthday("2000"), true);

    }
        if (app.db().groups().size() == 0) {
          app.groups().groupPage();
          app.groups().create(new GroupData().withName("test3"));
        }

    app.goTo().homePage();
    }


@Test
public void addUserToGroupTest(){
  Accounts accountsBefore = app.db().accounts();
  AccountCreation accountBefore = accountsBefore.iterator().next();
  Groups groups = app.db().groups();
  GroupData group = groups.iterator().next();
  app.user().select(accountBefore.getId(), group.getId());
  Accounts accountsAfter = app.db().accounts();
  AccountCreation accountAfter = new AccountCreation();
  for( AccountCreation g : accountsAfter){
    if( g.getId()==accountBefore.getId()){
      accountAfter = g;
      break;
    }
     }
  MatcherAssert.assertThat(accountAfter.getGroups(), CoreMatchers.equalTo(accountBefore.inGroup(group).getGroups()));
}}
