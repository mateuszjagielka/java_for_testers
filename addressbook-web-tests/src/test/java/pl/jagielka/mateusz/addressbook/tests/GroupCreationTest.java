package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCreationTest() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(
            new GroupData(
                    "test1",
                    "test2",
                    "test3"));
  }
}
