package pl.jagielka.mateusz.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactData {
  private int id;
  private String firstname;
  private String lastname;
  private String address;
  private String address2;
  private String email1;
  private String email2;
  private String email3;
  private String allEmails;
  private String homeNumber;
  private String mobileNumber;
  private String workNumber;
  private String allPhones;
  private String group;
  private String getAllDetails;
  private File photo;


  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getAddress2() {
    return address2;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllEmails() {
    return allEmails;
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

  public String getAllPhones() {
    return allPhones;
  }

  public String getGroup() {
    return group;
  }

  public String getGetAllDetails() {
    return getAllDetails;
  }

  public File getPhoto() {
    return photo;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
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

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withGetAllDetails(String getAllDetails) {
    this.getAllDetails = getAllDetails;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", contactName='" + firstname + '\'' +
            ", contactSurname='" + lastname + '\'' +
            '}';
  }


}
