package pl.jagielka.mateusz.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.GroupData;
import pl.jagielka.mateusz.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class GroupModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(
              new GroupData().withName("new name"));
    }
  }

  @Test
  public void groupModificationTest() throws Exception {
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("new name").withHeader("new header").withFooter("new footer");
    app.group().modify(group);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size());

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }

}
