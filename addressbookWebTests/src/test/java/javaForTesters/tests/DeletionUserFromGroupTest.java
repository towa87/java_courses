package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import javaForTesters.model.Accounts;
import javaForTesters.model.GroupData;
import javaForTesters.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static javaForTesters.tests.TestBase.app;

/**
 * Created by Антон on 10.10.2016.
 */
public class DeletionUserFromGroupTest extends TestBase  {
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
    app.user().select(app.db().accounts().iterator().next().getId(), app.db().groups().iterator().next().getId());
  }

 @Test
public void deleteUserFromGroupTest() {
   app.goTo().homePage();
     Groups groupsBefore = app.db().groups();

   GroupData modificationGroupBefore = new GroupData();
   for (GroupData g : groupsBefore) {
     if (g.getAccounts().size() > 0) {
       modificationGroupBefore = g;
       break;
     }       }

     AccountCreation accountToDelete = modificationGroupBefore.getAccounts().stream().iterator().next();
     app.groups().deleteAccountFromGroup(modificationGroupBefore, accountToDelete.getId());

     Groups groupsAfter = app.db().groups();
     GroupData modificationGroupAfter = new GroupData();
     for (GroupData h : groupsAfter) {
       if (h.getId() == modificationGroupBefore.getId()) {
         modificationGroupAfter = h;
         break;
       }}

       MatcherAssert.assertThat(modificationGroupBefore.getAccounts(), CoreMatchers.equalTo(modificationGroupAfter.getAccounts().withAdded(accountToDelete)));


 }}
