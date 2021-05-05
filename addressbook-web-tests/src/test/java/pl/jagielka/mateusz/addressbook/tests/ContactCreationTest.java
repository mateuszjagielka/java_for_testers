package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{

  @Test
  public void contactCreationTest() throws Exception {
    app.gotoAddNewContactPage();
    app.fillContactData(new ContactData("Adam", "Nowak", "569874125", "adam.nowak@secretmail.gov"));
    app.submitContactCreation();
  }
}
