package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Login_Steps {

    protected WebDriver driver;

    @Before("@login")
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

//    @After("@login")
//    public void tearDown() {
//        driver.quit();
//    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        this.driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }

    @When("I enter username {word}")
    public void i_enter_username_username(String username) {
        this.driver.findElement(By.cssSelector("#text")).sendKeys(username);
    }

    @And("I enter password {word}")
    public void i_enter_password_password(String password) {
        this.driver.findElement(By.cssSelector("#password")).sendKeys(password);
    }

    @And("I click on the login button")
    public void i_click_on_The_Login_Button() {
        this.driver.findElement(By.cssSelector("#login-button")).click();
    }

    @Then("I should be presented with the corresponding login message {string}")
    public void i_should_be_presented_with_the_the_successful_login_message(String string) {
        String loginMessage = this.driver.switchTo().alert().getText();
        Assert.assertEquals(loginMessage, string);
    }
}
