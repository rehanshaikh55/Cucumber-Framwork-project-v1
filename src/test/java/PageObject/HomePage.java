package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	  public HomePage(WebDriver driver) {
		  this.driver= driver;
	     PageFactory.initElements(driver, this);
	  }
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']") WebElement profileIcon; 
	@FindBy(xpath = "//a[normalize-space()='Logout']") WebElement logoutBtn;

public void clickProfile() {
	profileIcon.click();
}
public void clickLogoutBtn() {
	logoutBtn.click();
}
}
