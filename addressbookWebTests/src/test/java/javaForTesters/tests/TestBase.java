package javaForTesters.tests;

import javaForTesters.appManager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Антон on 21.08.2016.
 */
public class TestBase {

  protected final ApplicationManager applicationManager = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    applicationManager.init();
  }

  @AfterMethod
  public void tearDown() {
    applicationManager.stop();
  }

  public ApplicationManager getApplicationManager() {
    return applicationManager;
  }
}
