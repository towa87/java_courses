package javaForTesters.appManager;

import javaForTesters.model.AccountCreation;
import javaForTesters.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
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
    List<WebElement> elements = wd.findElements(By.name("entry"));
    List<WebElement> row = elements.get(id).findElements(By.tagName("td"));
    row.get(collumnForEditbutton).findElement(By.tagName("a")).click();




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

  }

  public boolean isThereUser() {
   return isElementPresent(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));  }

  public int getUserCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<AccountCreation> getUserList() {

    List<AccountCreation> users = new ArrayList<AccountCreation>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element: elements)
    {
      List<WebElement> cells = element.findElements(By.tagName("td"));

      String lastname = cells.get(1).getText();

      String firstname = cells.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      users.add(new AccountCreation(id, firstname, lastname, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
    }
    return users;
  }


}
