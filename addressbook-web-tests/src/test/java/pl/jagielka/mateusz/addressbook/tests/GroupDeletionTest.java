package pl.jagielka.mateusz.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.GroupData;

import java.util.List;

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
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }
}
