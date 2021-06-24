package pl.jagielka.mateusz.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;
import pl.jagielka.mateusz.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test (enabled = true)
  public void contactCreationTest() throws Exception {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    app.goTo().addNewContactPage();
    File photo = new File("src/test/resources/abc.png");
    ContactData contact = new ContactData()
            .withFirstname("Adam").withLastname("Nowak").withHomeNumber("569874125")
            .withEmail1("adam.nowak@secretmail.gov").withPhoto(photo).withGroup("test1");

    app.contact().create(contact,true);
    Assert.assertEquals(app.contact().count(), before.size() + 1);

    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/abc.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
    System.out.println(photo.isFile());
  }
}
