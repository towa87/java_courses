package javaForTesters.appManager;

import com.sun.xml.internal.fastinfoset.sax.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

/**
 * Created by Антон on 21.08.2016.
 */
public class ApplicationManager {
  //private final Properties properties;
    private String browser;

  WebDriver wd;

  private NavigationHelper navigationHelper;
  private GroupsHelper groupsHelper;
  private SessionHelper sessionHelper;
  private UserHelper userHelper;

  public ApplicationManager(String browser)  {
   // properties = new Properties();
    this.browser = browser;

  }


  public void init() throws FileNotFoundException {
   // String target = System.getProperty("target", "local");

   // properties.load(new FileReader( new File(String.format("scr/test/resources/$s.properties", target))));
   // String browser = BrowserType.FIREFOX;
    if (browser.equals(BrowserType.FIREFOX))
    {
    wd = new FirefoxDriver();}
    else if (browser.equals(BrowserType.CHROME))
    {wd = new ChromeDriver();}
    if (browser.equals(BrowserType.IE))
    {wd = new InternetExplorerDriver();}
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    //wd.get(properties.getProperty("web.baseUrl"));
    wd.get("http://localhost:8080/addressbook");
    groupsHelper = new GroupsHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    userHelper = new UserHelper(wd);
    sessionHelper.login("admin", "secret");
    //sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
  }


  public void stop() {
    wd.quit();
  }

  public GroupsHelper groups() {
    return groupsHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public UserHelper user() {
    return userHelper;
  }
}
