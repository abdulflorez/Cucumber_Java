package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {

    protected WebDriver driver;

    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    @Before("@contact-us")
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@contact-us")
    public void tearDown() {
        driver.quit();
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        this.driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        //--xpath version: By.xpath(//input[@name="first_name"])
        this.driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("AutoFN" + this.generateRandomNumber(5));
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        //--xpath version: By.xpath(//input[@name="last_name"])
        this.driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys("AutoLN" + this.generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        //--xpath version: By.xpath(//input[@name="email"])
        this.driver.findElement(By.cssSelector("input[name='email']")).sendKeys("autoEmail" + this.generateRandomNumber(5) + "@mail.com");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        //--xpath version: By.xpath(//textarea[@name="message"])
        this.driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("Hello world" + this.generateRandomString(5));
    }

    // ------  Dynamically params
    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        //--xpath version: By.xpath(//input[@name="first_name"])
        this.driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys(firstName);
    }

    @And("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        //--xpath version: By.xpath(//input[@name="last_name"])
        this.driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys(lastName);
    }

    @And("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        //--xpath version: By.xpath(//input[@name="email"])
        this.driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
    }

    @And("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        //--xpath version: By.xpath(//textarea[@name="message"])
        this.driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(comment);
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        //--xpath version: By.xpath(//input[@value="SUBMIT"])
        this.driver.findElement(By.cssSelector("input[value='SUBMIT']")).click();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        //--xpath version: By.xpath(//input[@value="SUBMIT"]/h1)
        WebElement contactUS_Submission_Message = driver.findElement(By.cssSelector("#contact_reply h1"));
        Assert.assertEquals(contactUS_Submission_Message.getText(), "Thank You for your Message!");
    }
}
