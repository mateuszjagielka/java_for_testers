package pl.jagielka.mateusz.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;
import pl.jagielka.mateusz.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test (enabled = true)
  public void contactCreationTest() throws Exception {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    app.goTo().addNewContactPage();
    ContactData contact = new ContactData()
            .withName("Adam").withSurname("Nowak").withHomeNumber("569874125")
            .withEmail("adam.nowak@secretmail.gov").withGroup("test1");

    app.contact().create(contact,true);
    Assert.assertEquals(app.contact().count(), before.size() + 1);

    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
