package pl.jagielka.mateusz.addressbook.model;

public class ContactData {
  private final String contactName;
  private final String contactSurname;
  private final String contactPhoneNumber;
  private final String contactEmail;
  private String group;

  public ContactData(String contactName, String contactSurname, String contactPhoneNumber, String contactEmail, String group) {
    this.contactName = contactName;
    this.contactSurname = contactSurname;
    this.contactPhoneNumber = contactPhoneNumber;
    this.contactEmail = contactEmail;
    this.group = group;
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

  public String getGroup() {
    return group;
  }
}
