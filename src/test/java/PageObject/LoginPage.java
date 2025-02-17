package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  WebDriver driver;
  public LoginPage(WebDriver driver) {
	this.driver = driver;
     PageFactory.initElements(driver, this);
  }
  
  @FindBy(xpath = "//input[@placeholder='Username']") WebElement usernameInput;
  @FindBy(xpath = "//input[@placeholder='Password']") WebElement passwordInput;
  @FindBy(xpath = "//button[normalize-space()='Login']") WebElement loginBtn;
  
  public void setUsername(String user) {
	  usernameInput.sendKeys(user);
  }
  public void setPassword(String pass) {
	  passwordInput.sendKeys(pass);
  }
  public void clickLoginBtn() {
	 loginBtn.click();
  }
}
