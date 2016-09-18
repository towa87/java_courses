package javaForTesters.appManager;

import javaForTesters.model.AccountCreation;
import javaForTesters.model.Accounts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Антон on 21.08.2016.
 */
public class UserHelper extends HelperBase {


  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void populationNewUserForm(AccountCreation accountCreation, boolean creation) {
    type(By.name("firstname"), accountCreation.getName());
    type(By.name("lastname"), accountCreation.getLastname1());
    type(By.name("nickname"), accountCreation.getNick());
    type(By.name("title"), accountCreation.getTitle());
    type(By.name("company"), accountCreation.getCompany());
    type(By.name("home"), accountCreation.getTelephoneHome());
    type(By.name("byear"), accountCreation.getBirthday());
    type(By.name("ayear"), accountCreation.getAyear());
    type(By.name("mobile"), accountCreation.getMobilePhone());
    type(By.name("work"), accountCreation.getMobilePhone2());
    type(By.name("work"), accountCreation.getWorkPhone());
    type(By.name("work"), accountCreation.getWorkPhone3());
    type(By.name("fax"), accountCreation.getWorkPhone2());
    type(By.name("email"), accountCreation.getEmail());
    type(By.name("homepage"), accountCreation.getHomepage());
    if (creation) {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(accountCreation.getGroup());
      }
    else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[7]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[7]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[8]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[8]"));
    }

    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[10]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[7]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[8]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[4]//option[8]"));
    }

    //if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[3]")).isSelected()) {
    //click(By.xpath("//div[@id='content']/form/select[5]//option[3]"));
    //}

  }

  private void Select(By locator) {
    wd.findElement(locator).isSelected();
  }

  public void submitCreationNewUserRecord() {

    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void editUser(int id ) {

   //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img") );
     int collumnForEditbutton = 7;

   // wd.findElement(By.cssSelector("input[value='" + id + "']"))
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for(int i = 0; i < elements.size(); i++) {
      List<WebElement> row = elements.get(i).findElements(By.tagName("td"));
     int value = Integer.parseInt(row.get(0).findElement(By.tagName("input")).getAttribute("value"));
        if (value == id)
        {row.get(collumnForEditbutton).findElement(By.tagName("a")).click();
        return;}
    }



    }

  public void editUserButton() {
    click(By.name("update"));


  }

  public void deleteUserButton() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }


  public void createUser(AccountCreation accountCreation, boolean b) {
  populationNewUserForm(accountCreation, b);
    submitCreationNewUserRecord();
    accountsCache = null;

  }

  public boolean isThereUser() {
   return isElementPresent(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));  }




  public void modify (AccountCreation user) {
    editUser(user.getId());
    populationNewUserForm(user, false);

    editUserButton();
    accountsCache = null;
  }


private Accounts accountsCache = null;
  public Accounts userList() {
if (accountsCache != null)
{
  return new Accounts(accountsCache);
}
    accountsCache = new Accounts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element: elements)
    {
      List<WebElement> cells = element.findElements(By.tagName("td"));

      String lastname = cells.get(1).getText();

      String firstname = cells.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      accountsCache.add(new AccountCreation().withId(id).withName("Ivan")
              .withLastname1("Smit").withNick("ST123").withNick("User")
              .withCompany("Software").withTelephoneHome("+4704888822")
              .withTelephoneHome2("+4704888822").withMobilePhone("+4704888821")
              .withMobilePhone2("+4704888821").withWorkPhone("+4704888821").withWorkPhone2("+4704888827")
              .withWorkPhone3("+4704888829").withEmail("test@test.com").withHomepage("localhost:8080/")
              .withAyear("1990").withBirthday("2000"));
    }
    return new Accounts(accountsCache);
  }

  public void delete(AccountCreation user) {
  editUser(user.getId());
    accountsCache = null;
  deleteUserButton();  }
}
