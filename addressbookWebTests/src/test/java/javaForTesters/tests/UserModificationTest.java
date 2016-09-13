package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Антон on 23.08.2016.
 */
public class UserModificationTest extends TestBase {
  @BeforeMethod
  public void ensureUserIsExcist() {
    app.goTo().homePage();

    if (!app.user().isThereUser()) {
      app.goTo().creationUserPage();
      app.user().createUser(new AccountCreation().withName("Ivan")
                      .withLastname1("Smit").withNick("ST123").withNick("User")
                      .withCompany("Software").withTelephoneHome("+4704888822")
                      .withTelephoneHome2("+4704888822").withMobilePhone("+4704888821")
                      .withMobilePhone2("+4704888821").withWorkPhone("+4704888821").withWorkPhone2("+4704888827")
                      .withWorkPhone3("+4704888829").withEmail("test@test.com").withHomepage("localhost:8080/")
                      .withAyear("1990").withBirthday("2000"), true);


              app.goTo().homePage();
    }
  }


  @Test
  public void testModificationUser() {
    List<AccountCreation> before = app.user().getUserList();
    int index = before.size() - 1;
    AccountCreation user = new AccountCreation().withId(before.get(index).getId()).withName("Ivan")
            .withLastname1("Smit").withNick("ST123").withNick("User")
            .withCompany("Software").withTelephoneHome("+4704888822")
            .withTelephoneHome2("+4704888822").withMobilePhone("+4704888821")
            .withMobilePhone2("+4704888821").withWorkPhone("+4704888821").withWorkPhone2("+4704888827")
            .withWorkPhone3("+4704888829").withEmail("test@test.com").withHomepage("localhost:8080/")
            .withAyear("1990").withBirthday("2000");
    app.user().modify(index, user);
    app.goTo().homePage();
    List<AccountCreation> after = app.user().getUserList();
    Assert.assertEquals(before.size(), after.size());
    before.remove(index);
    before.add(user);
    Comparator<? super AccountCreation> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);


  }


}