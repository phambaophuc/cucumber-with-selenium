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

public class DetailProductSteps {

    private final WebDriver webDriver;

    public DetailProductSteps() {
        webDriver = new EdgeDriver();
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        webDriver.get("http://localhost:4000/");
    }

    @And("I click on the product")
    public void iClickOnTheProduct() {
        List<WebElement> rows = webDriver.findElements(By.className("Products_avatar__c-S31"));
        WebElement firstRow = rows.get(0);
        firstRow.click();
    }

    @Then("I should see the product name")
    public void iShouldSeeTheProductName() {
        WebElement element = webDriver
                .findElement(By.className("ProductDetail_description-heading__vw43v"));
        Assert.assertNotNull(element);
    }
}
