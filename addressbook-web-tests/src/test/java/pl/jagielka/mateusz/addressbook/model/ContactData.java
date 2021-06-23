package pl.jagielka.mateusz.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private String name;
  private String lastname;
  private String homeNumber;
  private String mobileNumber;
  private String workNumber;
  private String allPhones;
  private String contactEmail;
  private String group;

  public String getName() {
    return name;
  }

  public String getSurname() {
    return lastname;
  }

  public String getHomeNumber() {
    return homeNumber;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public String getWorkNumber() {
    return workNumber;
  }

  public String getEmail() {
    return contactEmail;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String contactName) {
    this.name = contactName;
    return this;
  }

  public ContactData withSurname(String contactSurname) {
    this.lastname = contactSurname;
    return this;
  }

  public ContactData withHomeNumber(String contactHomeNumber) {
    this.homeNumber = contactHomeNumber;
    return this;
  }

  public ContactData withMobileNumber(String contactMobileNumber) {
    this.mobileNumber = contactMobileNumber;
    return this;
  }

  public ContactData withWorkNumber(String contactWorkNumber) {
    this.workNumber = contactWorkNumber;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
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
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", contactName='" + name + '\'' +
            ", contactSurname='" + lastname + '\'' +
            '}';
  }


}
