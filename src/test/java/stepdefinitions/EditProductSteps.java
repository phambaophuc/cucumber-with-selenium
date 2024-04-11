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

public class EditProductSteps {

    private static final int WAIT_TIMEOUT_SECONDS = 2;
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public EditProductSteps() {
        webDriver = new EdgeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    @Given("I am on the product management page edit")
    public void on_the_role_management() {
        webDriver.get("http://localhost:3001/#/booking/product");
    }

    @And("I click on the edit button")
    public void on_click() {
        List<WebElement> rows = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.className("btn-outline-info")));
        WebElement firstRow = rows.get(0);
        firstRow.click();
    }

    @And("I fill in the edit product Name as {string}")
    public void iFillInTheEditProductNameAs(String arg0) {
        fill_in_input_field(arg0, 0);
    }

    @And("I fill in the edit image as {string}")
    public void iFillInTheEditImageAs(String arg0) {
        fill_in_input_field(arg0, 1);
    }

    @And("I fill in the edit price as {string}")
    public void iFillInTheEditPriceAs(String arg0) {
        fill_in_input_field(arg0, 2);
    }

    @And("I fill in the edit quantity as {string}")
    public void iFillInTheEditQuantityAs(String arg0) {
        fill_in_input_field(arg0, 3);
    }

    @And("I fill in the edit des as {string}")
    public void iFillInTheEditDesAs(String arg0) {
        fill_in_input_field(arg0, 4);
    }

    @And("I fill in the edit id nsx as {string}")
    public void iFillInTheEditIdNsxAs(String arg0) {
        fill_in_input_field(arg0, 5);
    }

    @And("I fill in the edit id kho as {string}")
    public void iFillInTheEditIdKhoAs(String arg0) {
        fill_in_input_field(arg0, 6);
    }

    @And("I fill in the edit id cate as {string}")
    public void iFillInTheEditIdCateAs(String arg0) {
        fill_in_input_field(arg0, 7);
    }

    @And("I click on the Save edit button")
    public void on_save() {
        webDriver.findElement(By.className("btn-primary")).click();
    }

    @Then("I should see a message {string} after edit")
    public void see_message_after_edit(String message) {
        WebElement element = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
        String messageSuccess = element.getText();
        Assert.assertEquals(messageSuccess, message);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    private void fill_in_input_field(String value, int index) {
        List<WebElement> rows = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.className("ModalEditProduct_input-role__Q4wSH")));
        WebElement row = rows.get(index);
        row.clear();
        row.sendKeys(value);
    }
}
