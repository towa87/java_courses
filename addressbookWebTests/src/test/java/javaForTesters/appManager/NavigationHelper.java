package javaForTesters.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Антон on 21.08.2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }


  public void goToListOfUsersPage() {
    click(By.linkText("next birthdays"));
  }

  public void creationUserPage() {
    click(By.linkText("add new"));
  }



  public void homePage() {

    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }
  public void detailsUser(int id ) {

    int collumnFordDetailsButton = 6;

    // wd.findElement(By.cssSelector("input[value='" + id + "']"))
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for(int i = 0; i < elements.size(); i++) {
      List<WebElement> row = elements.get(i).findElements(By.tagName("td"));
      int value = Integer.parseInt(row.get(0).findElement(By.tagName("input")).getAttribute("value"));
      if (value == id)
      {row.get(collumnFordDetailsButton).findElement(By.tagName("a")).click();
        return;}
    }}
}
