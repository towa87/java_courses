package ru.stqa.pft.tests;


import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.appmanager.ApplicationManager;
import sun.net.ftp.FtpProtocolException;

;import java.io.File;
import java.io.IOException;

/**
 * Created by Антон on 21.08.2016.
 */
public class TestBase {
protected static final ApplicationManager app
        = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.back");
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException, FtpProtocolException {

    app.ftp().restore("config_inc.php.back", "config_inc.php");
    app.stop();
  }




    }
