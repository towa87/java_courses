package javaForTesters.appManager;

import javaForTesters.model.GroupData;
import javaForTesters.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.Properties;
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


  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();

  }
  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void navigateToGroupCreation() {
    click(By.linkText("group page"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    populateFieldsOfGroupForm(group);
    submitGroupCreation();
    groupCache = null;
    returnToGroupPage();
  }
public int count(){
  return wd.findElements(By.name("selected[]")).size();
}



  private Groups groupCache = null;
  public Groups all() {
    if (groupCache != null){
      return new Groups(groupCache);
    }
    groupCache = new Groups();
    List<WebElement> elemets = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elemets) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      // GroupData group = new GroupData().withId(id).withName(name);
      groupCache.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupCache);
  }
  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    populateFieldsOfGroupForm(group);
    submitGroupModification();
    groupCache = null;
    navigateToGroupCreation();
  }
  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("New"))) {
      return;
    }
    click(By.linkText("groups"));

  }



  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroup();
    groupCache = null;
    groupPage();
  }

  public void deleteAccountFromGroup(GroupData modificationGroupId, int idOfAccountToDelete) {
     wd.findElement(By.name("group")).findElement(By.cssSelector("option[value='"+ modificationGroupId.getId() +"']")).click();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for(int i = 0; i < elements.size(); i++) {
      List<WebElement> row = elements.get(i).findElements(By.tagName("td"));
      int value = Integer.parseInt(row.get(0).findElement(By.tagName("input")).getAttribute("value"));
      if (value == idOfAccountToDelete){
        row.get(0).findElement(By.tagName("input")).click();
        wd.findElement(By.name("remove")).click();
      }
      }
    }
  }

