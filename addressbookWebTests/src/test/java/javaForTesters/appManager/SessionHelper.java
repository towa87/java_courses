package javaForTesters.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Антон on 21.08.2016.
 */
public class SessionHelper extends HelperBase {


  public SessionHelper(FirefoxDriver wd) {

    super(wd);
  }
  public void login(String username, String password) {


  //  wd.findElement(By.name("pass")).click();
   // wd.findElement(By.name("pass")).sendKeys("\\undefined");
   // wd.findElement(By.cssSelector("html")).click();
    type(By.name("user"), username);
   // wd.findElement(By.name("user")).click();
    //wd.findElement(By.name("user")).click();
   // wd.findElement(By.name("user")).clear();
    //    wd.findElement(By.name("user")).sendKeys(username);
 //    wd.findElement(By.id("LoginForm")).click();
    type(By.name("pass"), password);
//    wd.findElement(By.name("pass")).click();
 //   wd.findElement(By.name("pass")).clear();
  //  wd.findElement(By.name("pass")).sendKeys(password);
   click(By.xpath("//form[@id='LoginForm']/input[3]"));
//    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }
}

