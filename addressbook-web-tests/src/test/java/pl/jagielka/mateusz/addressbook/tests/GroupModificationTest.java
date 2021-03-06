package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.GroupData;
import pl.jagielka.mateusz.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.group().create(
              new GroupData()
                      .withName(app.property().getProperty("group.name"))
                      .withHeader(app.property().getProperty("group.header"))
                      .withFooter(app.property().getProperty("group.footer")));
    }
  }

  @Test
  public void groupModificationTest() throws Exception {
    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId())
            .withName(app.property().getProperty("group.modified.name"))
            .withHeader(app.property().getProperty("group.modified.header"))
            .withFooter(app.property().getProperty("group.modified.footer"));
    app.goTo().groupPage();
    app.group().modify(group);
    assertEquals(app.group().count(), before.size());

    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    verifyGroupListInUI();
  }
}
