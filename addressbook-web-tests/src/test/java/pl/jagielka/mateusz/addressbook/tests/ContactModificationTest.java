package pl.jagielka.mateusz.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;
import pl.jagielka.mateusz.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(
              new ContactData()
                      .withFirstname(app.property().getProperty("contact.firstname"))
                      .withLastname(app.property().getProperty("contact.lastname"))
                      .withHomeNumber(app.property().getProperty("contact.homeNumber"))
                      .withEmail1(app.property().getProperty("contact.email1"))
                      .withGroup(app.property().getProperty("contact.group")),
              true);
    }
  }

  @Test (enabled = true)
  public void contactModificationTest() throws Exception {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstname(app.property().getProperty("contact.modified.firstname"))
            .withLastname(app.property().getProperty("contact.modified.lastname"));
    app.contact().modify(contact);
    Assert.assertEquals(app.contact().count(), before.size());

    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
