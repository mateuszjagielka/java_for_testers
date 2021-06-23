package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;
import pl.jagielka.mateusz.addressbook.model.Contacts;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

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
    if (contacts.size() == 0 || contacts.stream().filter((c) -> ! c.getAllEmails().equals("")).count() == 0) {
      app.contact().create(contact, true);
    }
  }

  @Test(enabled = true)
  public void contactEmailTests() {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactDataFromEditForm = app.contact().getDataFromEditForm(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactDataFromEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }
}
