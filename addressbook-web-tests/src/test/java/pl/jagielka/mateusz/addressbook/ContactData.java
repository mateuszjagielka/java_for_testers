package pl.jagielka.mateusz.addressbook;

public class ContactData {
  private final String contactName;
  private final String contactSurname;
  private final String contactPhoneNumber;
  private final String contactEmail;

  public ContactData(String contactName, String contactSurname, String contactPhoneNumber, String contactEmail) {
    this.contactName = contactName;
    this.contactSurname = contactSurname;
    this.contactPhoneNumber = contactPhoneNumber;
    this.contactEmail = contactEmail;
  }

  public String getContactName() {
    return contactName;
  }

  public String getContactSurname() {
    return contactSurname;
  }

  public String getContactPhoneNumber() {
    return contactPhoneNumber;
  }

  public String getContactEmail() {
    return contactEmail;
  }
}
