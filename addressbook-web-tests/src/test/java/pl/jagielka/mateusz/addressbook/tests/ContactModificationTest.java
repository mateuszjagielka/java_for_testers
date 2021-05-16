package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void contactModificationTest() throws Exception {

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
    app.getContactHelper().modifyContact();
    app.getContactHelper().fillContactData(
            new ContactData(
                    null,
                    null,
                    "123654789",
                    "marek.kowalski@gmail.com",
                    null),
            false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
  }
}
