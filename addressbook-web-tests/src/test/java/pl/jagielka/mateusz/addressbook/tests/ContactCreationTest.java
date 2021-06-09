package pl.jagielka.mateusz.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test (enabled = true)
  public void contactCreationTest() throws Exception {
    app.goTo().contactPage();
    List<ContactData> before = app.contact().list();
    app.goTo().addNewContactPage();
    ContactData contact = new ContactData(
            "Adam",
            "Nowak",
            "569874125",
            "adam.nowak@secretmail.gov",
            "test1");
    app.contact().create(contact,true);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    Comparator<? super ContactData> byId = (Comparator<ContactData>) (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    int max = after.stream().max(byId).get().getId();
    contact.setId(max);
    before.add(contact);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
