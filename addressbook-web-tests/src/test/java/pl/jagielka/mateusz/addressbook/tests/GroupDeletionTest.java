package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.GroupData;
import pl.jagielka.mateusz.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test 1"));
    }
  }

  @Test (enabled = true, invocationCount = 1)
  public void groupDeletionTest() throws Exception {
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    assertEquals(app.group().count(), before.size() - 1);

    Groups after = app.group().all();
    assertThat(after, equalTo(before.without(deletedGroup)));
  }

  @Test (enabled = false)
  public void allGroupsDeletion() throws Exception {
    app.goTo().groupPage();
    app.group().selectAllGroups();
    app.group().deleteSelectedGroups();
  }
}