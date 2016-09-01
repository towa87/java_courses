package javaForTesters.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Антон on 21.08.2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("New"))) {
      return;
    }
      click(By.linkText("groups"));

  }

  public void goToListOfUsersPage() {
    click(By.linkText("next birthdays"));
  }

  public void goToCreationUserPage() {
    click(By.linkText("add new"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void goToHomePage() {

    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

}
