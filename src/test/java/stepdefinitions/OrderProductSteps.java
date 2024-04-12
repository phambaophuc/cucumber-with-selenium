package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderProductSteps {

    private static final int WAIT_TIMEOUT_SECONDS = 2;
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public OrderProductSteps() {
        webDriver = new EdgeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    @Given("I on the login page")
    public void iOnTheLoginPage() {
        webDriver.get("http://localhost:4000/login");
        webDriver.findElement(By.className("SignInButton_wrapper__7c12x")).click();
    }

    @And("I will be logged in with {string} and {string}")
    public void iWillBeLoggedIn(String username, String password) {
        webDriver.findElement(By.name("username")).sendKeys(username);
        webDriver.findElement(By.name("password")).sendKeys(password);

        WebElement loginButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.className("Login_btnSubmit__CDwSq")));
        loginButton.click();
    }

    @And("I will go to the home page")
    public void iWillGoToTheHomePage() {
        webDriver.get("http://localhost:4000/");
    }

    @And("I see the product detail")
    public void iSeeTheProductDetail() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> rows = webDriver.findElements(By.className("Products_avatar__c-S31"));
        WebElement firstRow = rows.get(0);
        firstRow.click();
    }

    @And("I click on the add to cart button")
    public void iClickOnTheAddToCartButton() {
        webDriver.findElement(By.className("btn-add")).click();
    }

    @And("I wil go to cart page")
    public void iWilGoToCartPage() {
        webDriver.get("http://localhost:4000/cart");
    }

    @Then("I see if the product is in the cart")
    public void iSeeIfTheProductIsInTheCart() {
        WebElement element = webDriver
                .findElement(By.className("CartItem_cart-name__HgV-t"));
        Assert.assertNotNull(element);
    }
}
