package pl.jagielka.mateusz.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private String contactName;
  private String contactSurname;
  private String contactPhoneNumber;
  private String contactEmail;
  private String group;

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

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String contactName) {
    this.contactName = contactName;
    return this;
  }

  public ContactData withSurname(String contactSurname) {
    this.contactSurname = contactSurname;
    return this;
  }

  public ContactData withPhoneNumber(String contactPhoneNumber) {
    this.contactPhoneNumber = contactPhoneNumber;
    return this;
  }

  public ContactData withEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(contactName, that.contactName) && Objects.equals(contactSurname, that.contactSurname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, contactName, contactSurname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", contactName='" + contactName + '\'' +
            ", contactSurname='" + contactSurname + '\'' +
            '}';
  }


}
