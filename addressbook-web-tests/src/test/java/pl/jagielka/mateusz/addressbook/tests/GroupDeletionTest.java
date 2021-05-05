package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testUntitledTestCase() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }
}
