package javaForTesters.tests;

import javaForTesters.appManager.ApplicationManager;
import javaForTesters.model.AccountCreation;
import javaForTesters.model.Accounts;
import javaForTesters.model.GroupData;
import javaForTesters.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Антон on 21.08.2016.
 */
public class TestBase {
  Logger logger = LoggerFactory.getLogger(TestBase.class);
 protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));
  //protected static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  //public ApplicationManager getApp() {    return app;  }

  @BeforeMethod
  public void logTestStart(Method m, Object [] p){
    logger.info("Start test" + m.getName()+ "with parameters" + Arrays.asList(p));
  }
  @AfterMethod (alwaysRun = true)
  public void logTestStop(Method m){
    logger.info("Stop test" + m.getName());
  }

  public void verifyGroupListInUI() {
if(Boolean.getBoolean("verifyUI")){
    Groups dbGroups =app.db().groups();
    Groups uiGroups =app.groups().all();
    MatcherAssert.assertThat(uiGroups, CoreMatchers.equalTo(dbGroups.stream()
            .map((g)-> new GroupData().withId(g.getId()).withName(g.getName()))
            .collect(Collectors.toSet())));
  }}
  public void verifyAccountListInUI() {
    if(Boolean.getBoolean("verifyUI")){
      Accounts dbAccounts =app.db().accounts();
      Accounts  uiAccounts =app.user().userList();
      MatcherAssert.assertThat(uiAccounts, CoreMatchers.equalTo(dbAccounts.stream()
              .map((g)-> new AccountCreation().withId(g.getId()).withName(g.getName()).withLastname1(g.getLastname()).withAddress(g.getAddress())
                      .withEmail(g.getEmail()).withEmail2(g.getEmail2()).withEmail3(g.getEmail3()).withWorkPhone(g.getWorkPhone()).withMobilePhone(g.getMobilePhone())
              .withTelephoneHome(g.getTelephoneHome()))
              .collect(Collectors.toSet())));
    }
  }
}
