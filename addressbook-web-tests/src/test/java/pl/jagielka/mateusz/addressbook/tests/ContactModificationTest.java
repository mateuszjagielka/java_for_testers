package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void contactModificationTest() throws Exception {

    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().modifyContact();
    app.getContactHelper().fillContactData(new ContactData("Marek", "Kowalski", "841259637", "marek.kowalski@publicmail.com"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
  }
}
