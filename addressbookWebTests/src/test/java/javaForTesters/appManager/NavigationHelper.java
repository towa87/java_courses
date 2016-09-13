package javaForTesters.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

}
