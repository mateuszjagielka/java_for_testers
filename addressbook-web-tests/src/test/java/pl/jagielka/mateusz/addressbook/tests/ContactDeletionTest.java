package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void contactDeletionTest() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(
              new ContactData(
                      "Adam",
                      "Nowak",
                      "569874125",
                      "adam.nowak@secretmail.gov",
                      "test1"),
              true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().returnToContactPage();
  }
}
