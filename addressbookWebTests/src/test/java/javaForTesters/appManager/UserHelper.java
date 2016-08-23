package javaForTesters.appManager;

import javaForTesters.model.AccountCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Антон on 21.08.2016.
 */
public class UserHelper extends HelperBase {


  public UserHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void populationNewUserForm(AccountCreation accountCreation) {
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

  public void editUser() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[4]/td[8]/a/img"));
  }

  public void editUserButton() {
    click(By.name("update"));




  }

  public void deleteUserButton() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }


}
