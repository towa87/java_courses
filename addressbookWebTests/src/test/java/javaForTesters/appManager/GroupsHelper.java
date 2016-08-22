package javaForTesters.appManager;

import javaForTesters.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Антон on 21.08.2016.
 */
public class GroupsHelper extends HelperBase {

  public GroupsHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void populateFieldsOfGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void returnToGroupPage() {
    click(By.linkText("groups"));
  }

  public void deleteSelectedGroup() {
      new Actions(wd).doubleClick(wd.findElement(By.name("delete"))).build().perform();
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void submitGroupModification() {
click(By.name("update"));
  }

  public void navigateToGroupCreation() {
    click(By.linkText("group page"));
  }
}
