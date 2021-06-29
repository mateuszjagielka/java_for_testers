package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;
import pl.jagielka.mateusz.addressbook.model.Contacts;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    Contacts contacts = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname(app.property().getProperty("contact.firstname"))
            .withLastname(app.property().getProperty("contact.lastname"))
            .withAddress(app.property().getProperty("contact.address"))
            .withAddress2(app.property().getProperty("contact.address2"))
            .withHomeNumber(app.property().getProperty("contact.homeNumber"))
            .withMobileNumber(app.property().getProperty("contact.mobileNumber"))
            .withWorkNumber(app.property().getProperty("contact.workNumber"))
            .withEmail1(app.property().getProperty("contact.email1"))
            .withEmail2(app.property().getProperty("contact.email2"))
            .withEmail3(app.property().getProperty("contact.email3"))
            .withGroup(app.property().getProperty("contact.group"));
    if (contacts.size() == 0 || contacts.stream().filter((c) -> ! c.getAllPhones().equals("")).count() == 0) {
      app.contact().create(contact, true);
    }
  }

  @Test (enabled = true)
  public void contactPhoneTests() {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactDataFromEditForm = app.contact().getDataFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactDataFromEditForm)));
  }


}
