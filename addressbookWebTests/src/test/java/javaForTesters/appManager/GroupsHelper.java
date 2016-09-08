package javaForTesters.appManager;

import javaForTesters.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 21.08.2016.
 */
public class GroupsHelper extends HelperBase {

  public GroupsHelper(WebDriver wd) {
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

  public void selectGroup(int element) {
    wd.findElements(By.name("selected[]")).get(element).click();

  }

  public void submitGroupModification() {
click(By.name("update"));
  }

  public void navigateToGroupCreation() {
    click(By.linkText("group page"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    populateFieldsOfGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
  return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elemets = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element: elemets)
    {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData(id, name, null, null);
      groups.add(group);
    }
  return groups;
  }
}
