package pl.jagielka.mateusz.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.jagielka.mateusz.addressbook.model.ContactData;
import pl.jagielka.mateusz.addressbook.model.Contacts;
import pl.jagielka.mateusz.addressbook.model.GroupData;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactData(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getSurname());
    type(By.name("home"), contactData.getHomeNumber());
    type(By.name("mobile"), contactData.getMobileNumber());
    type(By.name("work"), contactData.getWorkNumber());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectContactById(int id) {
    wd.findElement(By.xpath("//input[@id='" + id + "']")).click();
  }

  public void submitContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
    confirmAlert();
  }

  public void initContactModificationById(int id) {
//    wd.findElement(By.xpath("//a[contains(@href,'edit.php?id="+ id + "')]")).click();
//    WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
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
        NavigationHelper goTo = new NavigationHelper(wd);
        GroupHelper group = new GroupHelper(wd);
        goTo.groupPage();
        group.create(new GroupData().withName(contact.getGroup()));
        goTo.addNewContactPage();
      }
    }
    fillContactData(contact, isCreation);
    submitContactCreation();
    contactsCache = null;
    returnToContactPage();

  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactData(contact, false);
    submitContactModification();
    contactsCache = null;
    returnToContactPage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    submitContactDeletion();
    contactsCache = null;
    returnToContactPage();
  }

  public int count() {
    return wd.findElements(By.xpath("//input[@name='selected[]']")).size();
  }

  public ContactData getDataFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.cssSelector("[name='firstname']")).getAttribute("value");
    String lastName = wd.findElement(By.cssSelector("[name='lastname']")).getAttribute("value");
    String homeNumber = wd.findElement(By.cssSelector("[name='home']")).getAttribute("value");
    String mobileNumber = wd.findElement(By.cssSelector("[name='mobile']")).getAttribute("value");
    String workNumber = wd.findElement(By.cssSelector("[name='work']")).getAttribute("value");
    String email = wd.findElement(By.cssSelector("[name='email']")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(firstName).withSurname(lastName)
            .withHomeNumber(homeNumber).withMobileNumber(mobileNumber).withWorkNumber(workNumber).withEmail(email);
  }

  public Contacts all() {
    if (contactsCache != null) {
      return new Contacts(contactsCache);
    }
    contactsCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String name = element.findElement(By.xpath("(./td)[3]")).getText();
      String surname = element.findElement(By.xpath("(./td)[2]")).getText();
      String allPhones = element.findElement(By.xpath("(./td)[6]")).getText();


      ContactData contact = new ContactData().withId(id).withName(name).withSurname(surname).withAllPhones(allPhones);
      contactsCache.add(contact);
    }
    return new Contacts(contactsCache);
  }

  private Contacts contactsCache = null;
}
