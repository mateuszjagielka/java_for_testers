package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;
import pl.jagielka.mateusz.addressbook.model.Contacts;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    Contacts contacts = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Adam").withLastname("Nowak")
            .withAddress("Longstreet 4, 54-389 London").withAddress2("Shortstreet 5, 54-859 Brighton")
            .withHomeNumber("+569874125").withMobileNumber("456-321").withWorkNumber("(45)6789")
            .withEmail1("adam.nowak@secretmail.gov").withEmail2("abc@def.gh")
            .withEmail3("hgf@edc.ba").withGroup("test1");
    if (contacts.size() == 0 || contacts.stream().filter((c) -> ! c.getAddress().equals("")).count() == 0) {
      app.contact().create(contact, true);
    }
  }

  @Test(enabled = true)
  public void contactAddressTests() {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactDataFromEditForm = app.contact().getDataFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactDataFromEditForm.getAddress()));
  }
}
