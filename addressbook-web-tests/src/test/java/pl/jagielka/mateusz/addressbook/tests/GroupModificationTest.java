package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.GroupData;

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
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().modifySelectedGroup();
    app.getGroupHelper().fillGroupForm(
            new GroupData(
                    "new name",
                    "new header",
                    "new footer"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
