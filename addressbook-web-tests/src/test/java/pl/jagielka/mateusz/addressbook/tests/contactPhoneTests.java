package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class contactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(
              new ContactData()
                      .withName("Adam").withSurname("Nowak").withHomeNumber("569874125").withMobileNumber("456321").withWorkNumber("456789")
                      .withEmail("adam.nowak@secretmail.gov").withGroup("test1"),
              true);
    }
  }

  @Test (enabled = true)
  public void ContactPhoneTests() {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactDataFromEditForm = app.contact().getDataFromEditForm(contact);

    assertThat(contact.getHomeNumber(), equalTo(cleaned(contactDataFromEditForm.getHomeNumber())));
    assertThat(contact.getMobileNumber(), equalTo(cleaned(contactDataFromEditForm.getMobileNumber())));
    assertThat(contact.getHomeNumber(), equalTo(cleaned(contactDataFromEditForm.getHomeNumber())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
