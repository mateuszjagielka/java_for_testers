package pl.jagielka.mateusz.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ContactCreationTest extends TestBase {

  @Test (enabled = true)
  public void contactCreationTest() throws Exception {
    app.goTo().contactPage();
    Set<ContactData> before = app.contact().all();
    app.goTo().addNewContactPage();
    ContactData contact = new ContactData()
            .withName("Adam").withSurname("Nowak").withPhoneNumber("569874125")
            .withEmail("adam.nowak@secretmail.gov").withGroup("test1");

    app.contact().create(contact,true);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
