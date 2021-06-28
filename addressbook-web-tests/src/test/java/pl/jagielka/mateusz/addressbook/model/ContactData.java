package pl.jagielka.mateusz.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {


  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id;

  @Expose
  @Column(name = "firstname")
  private String firstname;

  @Expose
  @Column(name = "lastname")
  private String lastname;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Transient
  private String address2;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email1;

  @Expose
  @Transient
  private String email2;

  @Expose
  @Transient
  private String email3;

  @XStreamOmitField
  @Transient
  private String allEmails;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String homeNumber;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobileNumber;

  @Expose
  @Transient
  private String workNumber;

  @XStreamOmitField
  @Transient
  private String allPhones;

  @Expose
  @Transient
  private String group;

  @XStreamOmitField
  @Transient
  private String getAllDetails;

  @XStreamOmitField
  @Transient
  private File photo;

  @Expose
  @Transient
  private String photoPath;


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

  public String getPhotoPath() {
    return photoPath;
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

  public ContactData withPhotoPath(String photoPath) {
    this.photoPath = photoPath;
    this.photo = new File(photoPath);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(address, that.address) && Objects.equals(email1, that.email1) && Objects.equals(homeNumber, that.homeNumber) && Objects.equals(mobileNumber, that.mobileNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, address, email1, homeNumber, mobileNumber);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            ", address2='" + address2 + '\'' +
            ", email1='" + email1 + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", homeNumber='" + homeNumber + '\'' +
            ", mobileNumber='" + mobileNumber + '\'' +
            ", workNumber='" + workNumber + '\'' +
            ", group='" + group + '\'' +
            ", photoPath='" + photoPath + '\'' +
            '}';
  }
}
