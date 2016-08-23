package javaForTesters.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Антон on 21.08.2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
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
    click(By.linkText("home"));
  }

 }
