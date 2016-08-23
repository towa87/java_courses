import javaForTesters.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class test extends TestBase{
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void test() {
        wd.get("http://localhost:8080/addressbook/edit.php?id=3");
        wd.findElement(By.xpath("//div/div[4]/form[1]/input[22]")).click();
        wd.findElement(By.xpath("//div[@id='content']/form[2]/input[2]")).click();
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[4]/td[8]/a/img")).click();
        wd.findElement(By.xpath("//div[@id='content']/form[2]/input[2]")).click();
        if (!wd.findElement(By.id("4")).isSelected()) {
            wd.findElement(By.id("4")).click();
        }
        wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
