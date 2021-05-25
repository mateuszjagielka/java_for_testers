package pl.jagielka.mateusz.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.GroupData;

import java.util.HashSet;
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
    GroupData group = new GroupData(
            before.get(before.size() - 1).getId(),
            "new name",
            "new header",
            "new footer");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));
  }
}
