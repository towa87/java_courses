package javaForTesters.tests;

import javaForTesters.model.AccountCreation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class UserCreationTest extends TestBase {

  @Test

  public void testUserCreation() {
    app.goTo().homePage();
    List<AccountCreation> before = app.user().getUserList();
    app.goTo().creationUserPage();
    AccountCreation account = new AccountCreation().withName("Ivan")
            .withLastname1("Smit").withNick("ST123").withNick("User")
            .withCompany("Software").withTelephoneHome("+4704888822")
            .withTelephoneHome2("+4704888822").withMobilePhone("+4704888821")
            .withMobilePhone2("+4704888821").withWorkPhone("+4704888821").withWorkPhone2("+4704888827")
            .withWorkPhone3("+4704888829").withEmail("test@test.com").withHomepage("localhost:8080/")
            .withAyear("1990").withBirthday("2000").withGroup("test3");
    app.user().createUser(account, true);
    app.goTo().homePage();
    List<AccountCreation> after = app.user().getUserList();
    Assert.assertEquals(after.size(), before.size() + 1);

   // account.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(account);
   Comparator<? super AccountCreation> byId = (a1, a2) -> Integer.compare(a1.getId(), a2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);

  }

}
