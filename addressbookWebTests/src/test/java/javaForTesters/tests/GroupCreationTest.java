package javaForTesters.tests;


import javaForTesters.model.GroupData;
import org.testng.annotations.Test;



public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    applicationManager.goToGroupPage();
    applicationManager.initGroupCreation();
    applicationManager.populateFieldsOfGroupForm(new GroupData("test3", "test5", "test6"));
    applicationManager.submitGroupCreation();
  }

}
