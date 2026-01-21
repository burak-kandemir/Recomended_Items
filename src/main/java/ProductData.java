public class ProductData {
    private String productName;
    // İhtiyaç olursa buraya price, quantity vb. ekleyebilirsin

    public ProductData(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}