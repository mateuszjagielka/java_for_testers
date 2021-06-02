package pl.jagielka.mateusz.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

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
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData(
                                  before.get(before.size() - 1).getId(),
                                  "Waldek",
                                  "Kowalski",
                                  null,
                                  null,
                                  null);
    app.getContactHelper().modifyContact(before.size() - 1);
    app.getContactHelper().fillContactData(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (Comparator<ContactData>) (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
