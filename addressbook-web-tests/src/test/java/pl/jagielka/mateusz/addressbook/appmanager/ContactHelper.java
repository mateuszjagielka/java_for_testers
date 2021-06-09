package pl.jagielka.mateusz.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.jagielka.mateusz.addressbook.model.ContactData;
import pl.jagielka.mateusz.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactData(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getContactName());
    type(By.name("lastname"), contactData.getContactSurname());
    type(By.name("mobile"), contactData.getContactPhoneNumber());
    type(By.name("email"), contactData.getContactEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectContact(int index) {
    wd.findElements(By.xpath("//tr/td/input")).get(index).click();
  }

  public void submitContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
    confirmAlert();
  }

  public void modifyContact(int index) {
    wd.findElements(By.xpath("//a[contains(@href,'edit.php?id=')]")).get(index).click();
  }

  public void submitContactModification() {
    click(By.xpath("(//input[@value='Update'])[2]"));
  }

  public void returnToContactPage() {
    click(By.linkText("home"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("(//tr/td/input)[1]"));
  }

  public void create(ContactData contact, boolean isCreation) {
    if (isCreation) {
      if (! isElementPresent(By.xpath("(//select[@name='new_group']/option) [2]")) || ! wd.findElement(By.xpath("(//select[@name='new_group']/option) [2]")).getText().equals(contact.getGroup())) {
        NavigationHelper navigationHelper = new NavigationHelper(wd);
        GroupHelper groupHelper = new GroupHelper(wd);
        navigationHelper.groupPage();
        groupHelper.create(new GroupData(
                contact.getGroup(),
                null,
                null));
        navigationHelper.addNewContactPage();
      }
    }
    fillContactData(contact, isCreation);
    submitContactCreation();
    returnToContactPage();

  }

  public void modify(ContactData contact, int index) {
    modifyContact(index);
    fillContactData(contact, false);
    submitContactModification();
    returnToContactPage();
  }

  public void delete(int index) {
    selectContact(index);
    submitContactDeletion();
    returnToContactPage();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String name = element.findElement(By.xpath("(./td)[3]")).getText();
      String surname = element.findElement(By.xpath("(./td)[2]")).getText();
      ContactData contact = new ContactData(id, name, surname, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }


}
