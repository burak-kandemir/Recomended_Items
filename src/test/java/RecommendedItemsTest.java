import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RecommendedItemsTest {

    @Test
    public void testAddRecommendedItemToCart() {
        // 1. Adım: Test verisini Builder ile hazırla
        ProductData expectedProduct = new ProductDataBuilder()
                .withProductName("Blue Top") // Sepette beklediğin ürünün tam adı
                .build();

        // 2. Adım: Test akışını başlat
        new HomePage()
                .load()
                .scrollToBottom()
                .verifyRecommendedItemsVisible()
                .clickAddToCartOnRecommended()
                .clickViewCart()
                .verifyProductDisplayed(expectedProduct); // Veriyi doğrulama için gönder
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}