package pl.jagielka.mateusz.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.jagielka.mateusz.addressbook.model.ContactData;
import pl.jagielka.mateusz.addressbook.model.GroupData;

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

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("(//tr/td/input)[1]"));
  }

  public void createContact(ContactData contact, boolean isCreation) {
    if (isCreation) {
      if (! isElementPresent(By.xpath("(//select[@name='new_group']/option) [2]"))) {
        NavigationHelper navigationHelper = new NavigationHelper(wd);
        GroupHelper groupHelper = new GroupHelper(wd);
        navigationHelper.gotoGroupPage();
        groupHelper.createGroup(new GroupData(
                contact.getGroup(),
                null,
                null));
        navigationHelper.gotoAddNewContactPage();
      }
    }
    fillContactData(contact, isCreation);
    submitContactCreation();
    returnToContactPage();

  }
}
