package pl.jagielka.mateusz.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.GroupData;
import pl.jagielka.mateusz.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroupsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File(app.property().getProperty("dataFilePathXml.groups"))))) {
      String xml ="";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(GroupData.class);
      List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
      return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File(app.property().getProperty("dataFilePathJson.groups"))))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<GroupData> groups = (List<GroupData>) gson
              .fromJson(json, new TypeToken<List<GroupData>>(){}.getType()); // can't use this: List<GroupData>.class
      return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test (dataProvider = "validGroupsFromJson", enabled = true, invocationCount = 1)
  public void groupCreationTest(GroupData group) throws Exception {
    app.goTo().groupPage();
    Groups before = app.db().groups();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.db().groups();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    verifyGroupListInUI();
  }

  @Test (enabled = false)
  public void badGroupCreationTest() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName(app.property().getProperty("group.badName"));
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));

    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }

  @Test (enabled = false, invocationCount = 10)
  public void fastGroupCreation() throws Exception {
    app.goTo().groupPage();
    GroupData group = new GroupData().withName(app.property().getProperty("group.name"));
    app.group().create(group);
  }
}