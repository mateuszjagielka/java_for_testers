package pl.jagielka.mateusz.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.jagielka.mateusz.addressbook.model.ContactData;
import pl.jagielka.mateusz.addressbook.model.Contacts;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    Contacts contacts = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname(app.property().getProperty("contact.firstname"))
            .withLastname(app.property().getProperty("contact.lastname"))
            .withAddress(app.property().getProperty("contact.address"))
            .withAddress2(app.property().getProperty("contact.address2"))
            .withHomeNumber(app.property().getProperty("contact.homeNumber"))
            .withMobileNumber(app.property().getProperty("contact.mobileNumber"))
            .withWorkNumber(app.property().getProperty("contact.workNumber"))
            .withEmail1(app.property().getProperty("contact.email1"))
            .withEmail2(app.property().getProperty("contact.email2"))
            .withEmail3(app.property().getProperty("contact.email3"))
            .withGroup(app.property().getProperty("contact.group"));
    if (contacts.size() == 0) {
      app.contact().create(contact, true);
    }
  }

  @Test(enabled = true)
  public void contactDetailsTests() {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().iterator().next();
    contact = app.contact().getDataFromEditForm(contact);
    String dataFromDetails = app.contact().getDataFromDetails(contact);

    assertThat(dataFromDetails, equalTo(mergeAllDataFromEditForm(contact, dataFromDetails)));
  }

  private String mergeAllDataFromEditForm(ContactData contact, String details) {
    return Arrays.asList(mergeNameWithAddress(contact), mergePhones(contact), mergeEmails(contact), mergeAddress2WithGroup(contact, details))
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n\n"));
  }

  private String mergeNameWithAddress(ContactData contact) {
    String fullName = Arrays.asList(contact.getFirstname(), contact.getLastname()).stream()
            .filter((s) -> ! s.equals("")).collect(Collectors.joining(" "));
    return Arrays.asList(fullName, contact.getAddress()).stream()
            .filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact) {
    String[] prefixes = {"H: ", "M: ", "W: "};
    String[] phones = {contact.getHomeNumber(), contact.getMobileNumber(), contact.getWorkNumber()};
    for (int i = 0; i < phones.length; i++) {
      if (! phones[i].equals(""))
        phones[i] = prefixes[i] + phones[i];
    }
    return Arrays.asList(phones)
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  private String mergeAddress2WithGroup(ContactData contact, String details) {
    String additionalLine = "";
    if (! contact.getAddress2().equals("") || ! getGroupFromContactDetails(details).equals("")) {
      additionalLine = "\n";
    }
    return additionalLine + Arrays.asList(contact.getAddress2(), getGroupFromContactDetails(details))
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n\n"));
  }

  private String getGroupFromContactDetails(String allDetails) {
    String[] cutDetails = allDetails.split("\n");
    return Arrays.stream(cutDetails).filter((c) -> c.contains("Member of:"))
            .collect(Collectors.joining());
  }
}
