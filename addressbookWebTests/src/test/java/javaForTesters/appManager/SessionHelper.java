package javaForTesters.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;
/**
 * Created by Антон on 21.08.2016.
 */
public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {

    type(By.name("user"), username);
    type(By.name("pass"), password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));

  }
}

