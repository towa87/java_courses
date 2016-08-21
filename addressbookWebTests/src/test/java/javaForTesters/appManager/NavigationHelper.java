package javaForTesters.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Антон on 21.08.2016.
 */
public class NavigationHelper {
 private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void goToGroupPage() {
    //groupsHelper.returnToGroupPage();
    wd.findElement(By.linkText("groups")).click();
  }

  public void goToListOfUsersPage() {
    wd.findElement(By.linkText("next birthdays")).click();
  }



  public void goToCreationUserPage() {
    wd.findElement(By.linkText("add new")).click();
  }

}
