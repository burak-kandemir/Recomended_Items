import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class CartPage {

    // Sepetteki tüm ürün isimlerini bulan locator
    private final By cartProductNames = By.xpath("//td[@class='cart_description']//a");

    // Parametre olarak ProductData alıyoruz
    public CartPage verifyProductDisplayed(ProductData productData) {
        List<WebElement> products = Driver.getDriver().findElements(cartProductNames);

        boolean isFound = false;
        for (WebElement product : products) {
            if (product.getText().equalsIgnoreCase(productData.getProductName())) {
                isFound = true;
                break;
            }
        }

        Assert.assertTrue(isFound,
                "Beklenen ürün sepette bulunamadı: " + productData.getProductName());

        return this;
    }
}