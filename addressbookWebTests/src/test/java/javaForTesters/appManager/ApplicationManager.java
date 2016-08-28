package javaForTesters.appManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Created by Антон on 21.08.2016.
 */
public class ApplicationManager {
  private String browser;
  WebDriver wd;

  private NavigationHelper navigationHelper;
  private GroupsHelper groupsHelper;
  private SessionHelper sessionHelper;
  private UserHelper userHelper;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }


  public void init() {
    //String browser = BrowserType.FIREFOX;
    if (browser.equals(BrowserType.FIREFOX))
    {
    wd = new FirefoxDriver();}
    else if (browser.equals(BrowserType.CHROME))
    {wd = new ChromeDriver();}
    if (browser.equals(BrowserType.IE))
    {wd = new InternetExplorerDriver();}
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get("http://localhost:8080/addressbook/birthdays.php");
    groupsHelper = new GroupsHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    userHelper = new UserHelper(wd);
    sessionHelper.login("admin", "secret");
  }


  public void stop() {
    wd.quit();
  }

  public GroupsHelper getGroupsHelper() {
    return groupsHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public UserHelper getUserHelper() {
    return userHelper;
  }
}
