package javaForTesters.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {


  @Test
  public void testDeletion() {
    applicationManager.goToGroupPage();
    applicationManager.selectGroup();
    applicationManager.deleteSelectedGroup();
    applicationManager.goToGroupPage();

  }


}
