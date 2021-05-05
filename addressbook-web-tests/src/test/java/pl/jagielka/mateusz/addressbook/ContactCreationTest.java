package pl.jagielka.mateusz.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{

  @Test
  public void contactCreationTest() throws Exception {
    gotoAddNewContactPage();
    fillContactData(new ContactData("Adam", "Nowak", "569874125", "adam.nowak@secretmail.gov"));
    submitContactCreation();
  }
}
