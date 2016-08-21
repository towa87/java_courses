package javaForTesters.appManager;

import javaForTesters.model.AccountCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Антон on 21.08.2016.
 */
public class UserHelper {
  private FirefoxDriver wd;

  public UserHelper(FirefoxDriver wd) {
    this.wd = wd;
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
}