package ru.stqa.pft.tests;

import org.testng.annotations.Test;

/**
 * Created by Антон on 14.10.2016.
 */
public class RegistrationTests extends TestBase{
  @Test
  public void testRegistration(){
    app.registration().start("user1","user1@localhost.localdomain");
  }

}
