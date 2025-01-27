public class Product {
    int productID;
    private String productName;
    private String title;
    private double price;
    private double startPrice;

    public Product() {
    }

    public Product(int productID, String productName, String title, double price, double startPrice) {
        this.productID = productID;
        this.productName = productName;
        this.title = title;
        this.price = price;
        this.startPrice = startPrice;
    }

    public Product(String productName, String title, double price) {
        this.productName = productName;
        this.title = title;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Product{id='" + productID + "', name='" + productName + "', buyNowPrice=" + price + "}";
    }
}
