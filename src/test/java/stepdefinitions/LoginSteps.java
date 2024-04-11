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


public class LoginSteps {

    private static final int WAIT_TIMEOUT_SECONDS = 2;
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public LoginSteps() {
        webDriver = new EdgeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        webDriver.get("http://localhost:4000/login");
        webDriver.findElement(By.className("SignInButton_wrapper__7c12x")).click();
    }

    @And("I fill in the User Name as {string}")
    public void i_fill_in_the_user_name_as(String userName) {
        webDriver.findElement(By.name("username")).sendKeys(userName);
    }

    @And("I fill in the Password as {string}")
    public void i_fill_in_the_password_as(String password) {
        webDriver.findElement(By.name("password")).sendKeys(password);
    }

    @When("I click on the Log In button")
    public void i_click_on_the_log_in_button() {
        WebElement loginButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.className("Login_btnSubmit__CDwSq")));
        loginButton.click();
    }

    @Then("I should be redirected to the {string}")
    public void i_see_the_message(String url) throws InterruptedException {
        Thread.sleep(2000);
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, url);
    }

    @Then("I see the error message {string}")
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
