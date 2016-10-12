package ru.stqa.pft.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Антон on 12.10.2016.
 */
public class LoginTest extends TestBase {
  @Test
  public void testLogin() throws IOException {
    HttpSession session = app.newSession();
    assertTrue(session.login("administrator", "root"));
    assertTrue(session.isLoggedInAs("administrator"));
  }

}
