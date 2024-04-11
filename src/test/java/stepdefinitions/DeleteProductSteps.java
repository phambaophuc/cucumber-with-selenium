package stepdefinitions;

import io.cucumber.java.After;
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

public class DeleteProductSteps {

    private static final int WAIT_TIMEOUT_SECONDS = 2;
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public DeleteProductSteps() {
        webDriver = new EdgeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    @Given("I am on the product management page")
    public void on_the_role_management() {
        webDriver.get("http://localhost:3001/#/account/role");
    }

    @And("I click on the delete button")
    public void on_delete() {
        List<WebElement> rows = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.className("btn-outline-danger")));
        WebElement firstRow = rows.get(0);
        firstRow.click();
    }

    @And("I click on the confirm button")
    public void on_confirm() {
        WebElement loginButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.className("btn-primary")));
        loginButton.click();
    }

    @Then("I should see a message {string} after deleted")
    public void see_message_after_deleted(String message) {
        WebElement element = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
        String messageSuccess = element.getText();
        Assert.assertEquals(messageSuccess, message);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
