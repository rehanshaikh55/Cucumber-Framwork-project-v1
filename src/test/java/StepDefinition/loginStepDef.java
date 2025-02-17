package StepDefinition;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import PageObject.HomePage;
import PageObject.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginStepDef {
    public static WebDriver driver;
    public LoginPage lp;
    public HomePage hp;

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
}
