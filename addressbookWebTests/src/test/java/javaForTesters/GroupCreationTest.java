package javaForTesters;


import org.testng.annotations.Test;



public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    goToGroupPage();
    initGroupCreation();
    populateFieldsOfGroupForm(new GroupData("test3", "test5", "test6"));
    submitGroupCreation();
  }

}
