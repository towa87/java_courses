package javaForTesters;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Антон on 21.08.2016.
 */
public class TestBase {
  FirefoxDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost:8080/addressbook/birthdays.php");
    login("admin", "secret");
  }

  public void login(String username, String password) {
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).sendKeys("\\undefined");
    wd.findElement(By.cssSelector("html")).click();
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void populateFieldsOfGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  public void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  public void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void goToListOfUsersPage() {
      wd.findElement(By.linkText("next birthdays")).click();
  }

  public void populationNewUserForm(AccountCreation accountCreation) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(accountCreation.getName());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(accountCreation.getLastname1());
      wd.findElement(By.name("nickname")).click();
      wd.findElement(By.name("nickname")).clear();
      wd.findElement(By.name("nickname")).sendKeys(accountCreation.getNick());
      wd.findElement(By.name("title")).click();
      wd.findElement(By.name("title")).clear();
      wd.findElement(By.name("title")).sendKeys(accountCreation.getTitle());
            wd.findElement(By.name("company")).click();
      wd.findElement(By.name("company")).clear();
      wd.findElement(By.name("company")).sendKeys(accountCreation.getCompany());
      wd.findElement(By.name("address")).click();
      wd.findElement(By.name("home")).click();
      wd.findElement(By.name("home")).clear();
      wd.findElement(By.name("home")).sendKeys(accountCreation.getTelephoneHome());
      wd.findElement(By.name("home")).click();
      wd.findElement(By.name("home")).clear();
      wd.findElement(By.name("home")).sendKeys(accountCreation.getTelephoneHome2());
      wd.findElement(By.name("mobile")).click();
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(accountCreation.getMobilePhone());
      wd.findElement(By.name("work")).click();
      wd.findElement(By.name("mobile")).click();
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(accountCreation.getMobilePhone2());
      wd.findElement(By.name("work")).click();
      wd.findElement(By.name("work")).clear();
      wd.findElement(By.name("work")).sendKeys(accountCreation.getWorkPhone());
      wd.findElement(By.name("fax")).click();
      wd.findElement(By.name("fax")).clear();
      wd.findElement(By.name("fax")).sendKeys(accountCreation.getWorkPhone2());
      wd.findElement(By.name("work")).click();
      wd.findElement(By.name("work")).clear();
      wd.findElement(By.name("work")).sendKeys(accountCreation.getWorkPhone3());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(accountCreation.getEmail());
      wd.findElement(By.name("homepage")).click();
      wd.findElement(By.name("homepage")).clear();
      wd.findElement(By.name("homepage")).sendKeys(accountCreation.getHomepage());
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[7]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[7]")).click();
      }
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[8]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[8]")).click();
      }
      wd.findElement(By.name("byear")).click();
      wd.findElement(By.name("byear")).clear();
      wd.findElement(By.name("byear")).sendKeys(accountCreation.getBirthday());
      wd.findElement(By.name("theform")).click();
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[10]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[10]")).click();
      }
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[8]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[8]")).click();
      }
      wd.findElement(By.name("ayear")).click();
      wd.findElement(By.name("ayear")).clear();
      wd.findElement(By.name("ayear")).sendKeys(accountCreation.getAyear());
      wd.findElement(By.xpath("//div[@id='content']//label[.='Group:']")).click();
      wd.findElement(By.xpath("//div[@id='content']//label[.='Anniversary:']")).click();
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[3]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[3]")).click();
      }

  }

  public void submitCreationNewUserRecord() {
     wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
     // wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public void goToCreationUserPage() {
      wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public void returnToGroupPage() {
      wd.findElement(By.linkText("groups")).click();
  }

  public void deleteSelectedGroup() {
      new Actions(wd).doubleClick(wd.findElement(By.name("delete"))).build().perform();
  }

  public void selectGroup() {
      wd.findElement(By.name("selected[]")).click();
  }
}
