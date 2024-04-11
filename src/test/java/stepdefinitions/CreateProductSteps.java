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

public class CreateProductSteps {

    private static final int WAIT_TIMEOUT_SECONDS = 2;
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public CreateProductSteps() {
        webDriver = new EdgeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    @Given("I am on the add product page")
    public void on_the_role_page() {
        webDriver.get("http://localhost:3001/#/booking/product/addProduct");
    }

    @And("I fill in the Product Name as {string}")
    public void fill_in_product_name(String product) {
        fill_in_input_field(product, 0);
    }

    @And("I fill in the Image as {string}")
    public void iFillInTheImageAs(String arg0) {
        fill_in_input_field(arg0, 1);
    }

    @And("I fill in the Price as {string}")
    public void iFillInThePriceAs(String arg0) {
        fill_in_input_field(arg0, 2);
    }

    @And("I fill in the Quantity as {string}")
    public void iFillInTheQuantityAs(String arg0) {
        fill_in_input_field(arg0, 3);
    }

    @And("I fill in the Des as {string}")
    public void iFillInTheDesAs(String arg0) {
        fill_in_input_field(arg0, 4);
    }

    @And("I fill in the id nsx as {string}")
    public void iFillInTheIdNsxAs(String arg0) {
        fill_in_input_field(arg0, 5);
    }

    @And("I fill in the id kho as {string}")
    public void iFillInTheIdKhoAs(String arg0) {
        fill_in_input_field(arg0, 6);
    }

    @And("I fill in the id cate as {string}")
    public void iFillInTheIdCateAs(String arg0) {
        fill_in_input_field(arg0, 7);
    }

    private void fill_in_input_field(String value, int index) {
        List<WebElement> rows = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.className("ModalAddNews_input-role__NSlkD")));
        WebElement row = rows.get(index);
        row.sendKeys(value);
    }

    @And("I click on the Save button")
    public void on_save() {
        webDriver.findElement(By.className("btn-primary")).click();
    }

    @Then("I should see a message {string}")
    public void see_message(String message) {
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
