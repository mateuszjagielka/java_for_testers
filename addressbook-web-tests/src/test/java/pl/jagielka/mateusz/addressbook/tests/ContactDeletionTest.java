package pl.jagielka.mateusz.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;
import pl.jagielka.mateusz.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.db().contacts().size() == 0) {
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
  public void contactDeletionTest() throws Exception {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Assert.assertEquals(app.contact().count(), before.size() - 1);

    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
