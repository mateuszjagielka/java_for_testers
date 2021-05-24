package pl.jagielka.mateusz.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTest extends TestBase{

  @Test
  public void groupModificationTest() throws Exception {
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
    app.getGroupHelper().modifySelectedGroup();
    app.getGroupHelper().fillGroupForm(
            new GroupData(
                    "new name",
                    "new header",
                    "new footer"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());
  }
}
