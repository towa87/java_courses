package javaForTesters.tests;

import javaForTesters.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by Антон on 22.08.2016.
 */
public class GroupModificationTest extends TestBase {
  @Test
  public void testModifiction() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupsHelper().selectGroup();
    app.getNavigationHelper().initGroupModification();
    app.getGroupsHelper().populateFieldsOfGroupForm(new GroupData("test3", "test5", "test6"));
    app.getGroupsHelper().submitGroupModification();
    app.getGroupsHelper().navigateToGroupCreation();
  }
}
