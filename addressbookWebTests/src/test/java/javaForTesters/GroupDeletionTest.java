package javaForTesters;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

    
    @Test
    public void testGroupDeletion() {
       goToGroupPage();
        selectGroup();
        deleteSelectedGroup();
        returnToGroupPage();
    }


}
