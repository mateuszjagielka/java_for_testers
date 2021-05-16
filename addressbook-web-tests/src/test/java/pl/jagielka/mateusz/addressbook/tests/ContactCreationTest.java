package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void contactCreationTest() throws Exception {
    app.getNavigationHelper().gotoAddNewContactPage();
    app.getContactHelper().createContact(
            new ContactData(
                    "Adam",
                    "Nowak",
                    "569874125",
                    "adam.nowak@secretmail.gov",
                    "test1"),
            true);
  }
}
