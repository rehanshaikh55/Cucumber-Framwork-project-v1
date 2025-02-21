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
	@FindBy(xpath ="//aside[@class='oxd-sidepanel']//li[1]") WebElement adminButton;
	@FindBy(xpath ="//button[normalize-space()='Add']") WebElement addButton;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")WebElement userRoleSelect;
     @FindBy(xpath="//span[contains(text(),'Admin')]") WebElement selectAdmin;
     @FindBy(xpath="//input[@placeholder='Type for hints...']") WebElement inputEmpName;
     @FindBy(xpath="//span[contains(text(),'Ranga  Akunuri')]") WebElement empJeon;
     @FindBy(xpath="//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]")WebElement statusSelect;
     @FindBy(xpath="//span[normalize-space()='Enabled']") WebElement selectEnabled;
     @FindBy(xpath="//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")WebElement inputUsername;
     @FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")WebElement inputPwd;
     @FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")WebElement inpuConfirmPwd;
     @FindBy(xpath="//button[normalize-space()='Save']") WebElement saveBtn; 
     @FindBy(xpath="//p[contains(text(),'Success']") WebElement successDiv;
     
public void clickProfile() {
	profileIcon.click();
}
public void clickLogoutBtn() {
	logoutBtn.click();
}
public void clickAdminBtn() {
	adminButton.click();
}
public void clickAddBtn() {
	addButton.click();
}
public void selectUserRole() {
	userRoleSelect.click();
	selectAdmin.click();
}

public void setEmpName(String name) {
	inputEmpName.sendKeys(name);
	empJeon.click();
}
public void selectstatus() {
	statusSelect.click();
	selectEnabled.click();
}
public void setUsername(String Username) {
	inputUsername.sendKeys(Username);
}
public void setPassword(String pass,String confirmPass) {
	inputPwd.sendKeys(pass);
	inpuConfirmPwd.sendKeys(confirmPass);
}

public void clickSaveBtn() {
	saveBtn.click();
}
public Boolean checkSuccess() {
	return successDiv.isDisplayed();
}

}
