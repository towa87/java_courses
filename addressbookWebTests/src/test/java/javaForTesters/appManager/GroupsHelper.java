package javaForTesters.appManager;

import javaForTesters.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Антон on 21.08.2016.
 */
public class GroupsHelper {
  private FirefoxDriver wd;

  public GroupsHelper(FirefoxDriver wd) {
    this.wd = wd;
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
