package StepDefinition;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

import PageObject.HomePage;
import PageObject.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginStepDef {
    public static WebDriver driver;
    public LoginPage lp;
    public HomePage hp;
    public SoftAssert sa;
    public String randomInteger() {
		@SuppressWarnings("deprecation")
		String generatedInteger =RandomStringUtils.randomNumeric(3);
		return generatedInteger;
		
	}
    public String randomString() {
		@SuppressWarnings("deprecation")
		String generatedString =RandomStringUtils.randomAlphabetic(10);
		return generatedString;
		
	}
    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        
        driver = new ChromeDriver();
        
        lp = new LoginPage(driver);
        hp = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user opens url {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @When("user enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String user, String pass) {
        lp.setUsername(user);
        lp.setPassword(pass);
    }

    @When("click on Login")
    public void click_on_login() {
        lp.clickLoginBtn();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String title) {
    	SoftAssert sa= new SoftAssert();
       sa.assertEquals(title, driver.getTitle());
    }

    @When("user click on profile")
    public void user_click_on_profile() {
        hp.clickProfile();
    }

    @When("Click on Logout")
    public void click_on_logout() {
        hp.clickLogoutBtn();
    }

    @Then("close browser")
    public void close_browser() throws IOException, URISyntaxException {
    	
        driver.quit();
    }
    @Then("{string} Error message should popup")
    public void error_message_should_popup(String err) {
       

    
      Assert.assertEquals(lp.checkErrorMsg(),err);
    }
    @Then("click on Admin Section in Dashboard")
	public void click_on_admin_section_in_dashboard() {
	    hp.clickAdminBtn();
	    
	}

	@Then("Click on Add Button")
	public void click_on_add_button() {
	    hp.clickAddBtn();
	    
	}

	@Then("add user details in from")
	public void add_user_details_in_from() throws InterruptedException {
	    hp.selectUserRole();
	    hp.setEmpName("Ranga  Akunuri");
	    hp.selectstatus();
	    hp.setUsername("Rehan"+randomInteger());
	    Thread.sleep(1000);
	    String pass = "abcd@123";
	    hp.setPassword(pass, pass);
	    hp.clickSaveBtn();
	    
	}

	@Then("Click on save")
	public void clicks_on_save() throws InterruptedException {
	    hp.clickSaveBtn();
	    
	}
	@And("checking success message")
	public void checking_success_message() {
	   
	   Assert.assertTrue( true);
	}
}
