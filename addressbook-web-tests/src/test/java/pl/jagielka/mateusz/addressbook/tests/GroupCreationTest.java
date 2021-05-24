package pl.jagielka.mateusz.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCreationTest() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(
            new GroupData(
                    "test1",
                    "test2",
                    "test3"));
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}
