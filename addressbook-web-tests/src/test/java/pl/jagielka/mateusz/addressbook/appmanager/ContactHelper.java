package pl.jagielka.mateusz.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.jagielka.mateusz.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactData(ContactData contactData) {
    type(By.name("firstname"), contactData.getContactName());
    type(By.name("lastname"), contactData.getContactSurname());
    type(By.name("mobile"), contactData.getContactPhoneNumber());
    type(By.name("email"), contactData.getContactEmail());
  }

  public void selectContact() {
    click(By.xpath("(//tr/td/input)[1]"));
  }

  public void submitContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
    confirmAlert();
  }

  public void modifyContact() {
    click(By.xpath("(//a[contains(@href,'edit.php?id=')])[1]"));
  }

  public void submitContactModification() {
    click(By.xpath("(//input[@value='Update'])[2]"));
  }

  public void returnToContactPage() {
    click(By.linkText("home"));
  }


}
