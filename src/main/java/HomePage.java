import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class HomePage {

    // Locators
    private final By recommendedItemsHeader = By.xpath("//div[@class='recommended_items']//h2[text()='recommended items']");
    private final By addToCartButton = By.xpath("(//div[@class='recommended_items']//a[contains(@class,'add-to-cart')])[1]");
    private final By viewCartLink = By.xpath("//u[text()='View Cart']");
    private final By modalContent = By.id("cartModal");

    // Step 2: Navigate to URL
    public HomePage load() {
        Driver.getDriver().get("http://automationexercise.com");
        return this;
    }

    // Step 3: Scroll to bottom
    public HomePage scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }

    // Step 4: Verify 'RECOMMENDED ITEMS' are visible
    public HomePage verifyRecommendedItemsVisible() {
        WebElement header = Driver.getDriver().findElement(recommendedItemsHeader);
        Assert.assertTrue(header.isDisplayed(), "'RECOMMENDED ITEMS' header is not visible!");
        return this;
    }

    // Step 5: Click on 'Add To Cart' on Recommended product
    public HomePage clickAddToCartOnRecommended() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

        // Sometimes JS click is safer for elements at the very bottom or covered by footers
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", button);
        return this;
    }

    // Step 6: Click on 'View Cart' button
    public CartPage clickViewCart() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalContent));

        Driver.getDriver().findElement(viewCartLink).click();
        return new CartPage(); // Transitions to the next page object
    }
}