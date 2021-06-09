package pl.jagielka.mateusz.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().list().size() == 0) {
      app.contact().create(
              new ContactData(
                      "Adam",
                      "Nowak",
                      "569874125",
                      "adam.nowak@secretmail.gov",
                      "test1"),
              true);
    }
  }

  @Test (enabled = true)
  public void contactModificationTest() throws Exception {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData(
                                  before.get(before.size() - 1).getId(),
                                  "Waldek",
                                  "Kowalski",
                                  null,
                                  null,
                                  null);
    int index = before.size() - 1;
    app.contact().modify(contact, index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (Comparator<ContactData>) (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
