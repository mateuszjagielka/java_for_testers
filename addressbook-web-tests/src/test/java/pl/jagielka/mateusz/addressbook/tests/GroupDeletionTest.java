package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {

  @Test
  public void groupDeletionTest() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(
              new GroupData(
                      "new name",
                      null,
                      null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }
}
