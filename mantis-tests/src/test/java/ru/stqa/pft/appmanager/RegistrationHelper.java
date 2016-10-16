package ru.stqa.pft.appmanager;

import org.openqa.selenium.WebDriver;

/**
 * Created by Антон on 14.10.2016.
 */
public class RegistrationHelper {


  private final ApplicationManager app;
  private final WebDriver wd;

  public RegistrationHelper(ApplicationManager app) {
    this.app = app;
     wd = app.getDriver();
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseURl") + "/signup_page.php");
  }
}
