package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterSteps {

    private static final int WAIT_TIMEOUT_SECONDS = 2;
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public RegisterSteps() {
        webDriver = new EdgeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    @Given("I am on the registration page")
    public void i_am_on_the_sample_app_login_page() {
        webDriver.get("http://localhost:4000/register");
        webDriver.findElement(By.className("SignInButton_wrapper__7c12x")).click();
    }

    @When("I fill in the form First Name as {string}")
    public void i_fill_in_the_first_name_as(String firstName) {
        webDriver.findElement(By.name("firstName")).sendKeys(firstName);
    }

    @And("I fill in the form Last Name as {string}")
    public void i_fill_in_the_last_name_as(String lastName) {
        webDriver.findElement(By.name("lastName")).sendKeys(lastName);
    }

    @And("I fill in the form Username as {string}")
    public void i_fill_in_the_username_as(String username) {
        webDriver.findElement(By.name("username")).sendKeys(username);
    }

    @And("I fill in the form Email as {string}")
    public void i_fill_in_the_email_as(String email) {
        webDriver.findElement(By.name("email")).sendKeys(email);
    }

    @And("I fill in the form Password as {string}")
    public void i_fill_in_the_password_as(String password) {
        webDriver.findElement(By.name("password")).sendKeys(password);
    }

    @And("I click on the Register button")
    public void i_click_on_the_register_button() {
        WebElement registerButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.className("Register_btnSubmit__u9bfv")));
        registerButton.click();
    }

    @Then("I should be redirected to the {string} after registration")
    public void i_should_be_redirected_to_the_home_page(String url) throws InterruptedException {
        Thread.sleep(2000);
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, url);
    }

    @Then("I see the error message {string} after registration")
    public void i_see_the_error_message(String errorMessage) {
        WebElement errorMessageElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@role='alert']")));

        String actualErrorMessage = errorMessageElement.getText();
        Assert.assertEquals(actualErrorMessage, errorMessage);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
