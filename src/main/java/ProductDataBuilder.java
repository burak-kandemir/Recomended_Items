public class ProductDataBuilder {
    private String productName;

    public ProductDataBuilder withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductData build() {
        return new ProductData(productName);
    }
}