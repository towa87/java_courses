package ru.stqa.pft.appmanager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Антон on 21.08.2016.
 */
public class ApplicationManager {
  private final Properties properties;
  WebDriver wd;
    private String browser;

  public ApplicationManager(String browser)  {
    properties = new Properties();
    this.browser = browser;

  }


  public void init() throws IOException {

    String target = System.getProperty("target", "local");
    properties.load(new FileReader( new File(String.format("src/test/resources/%s.properties", target))));

    if (browser.equals(BrowserType.FIREFOX))
    {
    wd = new FirefoxDriver();}
    else if (browser.equals(BrowserType.CHROME))
    {wd = new ChromeDriver();}
    if (browser.equals(BrowserType.IE))
    {wd = new InternetExplorerDriver();}
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseURl"));
    //wd.get("http://localhost:8080/addressbook/birthdays.php");

    // sessionHelper.login("admin", "secret");
   // sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));

  }


  public void stop() {
    wd.quit();
  }

public HttpSession newSession(){
  return new HttpSession(this);
}

  public String getProperty(String key) {
    return properties.getProperty(key);
  }
}
