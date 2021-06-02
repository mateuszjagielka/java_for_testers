package pl.jagielka.mateusz.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String contactName;
  private final String contactSurname;
  private final String contactPhoneNumber;
  private final String contactEmail;
  private String group;

  public ContactData(int id, String contactName, String contactSurname, String contactPhoneNumber, String contactEmail, String group) {
    this.id = id;
    this.contactName = contactName;
    this.contactSurname = contactSurname;
    this.contactPhoneNumber = contactPhoneNumber;
    this.contactEmail = contactEmail;
    this.group = group;
  }

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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(contactName, that.contactName) && Objects.equals(contactSurname, that.contactSurname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", contactName='" + contactName + '\'' +
            ", contactSurname='" + contactSurname + '\'' +
            '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, contactName, contactSurname);
  }


}
