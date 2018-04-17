package shoppingbasket;

public class OrderItem {

    private String ProductName;
    private int quantity;
    private double LatestPrice;
    private String ref;

    public OrderItem(String name, int quantity, double price, String ref) {
        this.ProductName = name;
        this.quantity = quantity;
        this.LatestPrice = price;
        this.ref = ref;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getLatestPrice() {
        return LatestPrice;
    }

    public void setLatestPrice(double LatestPrice) {
        this.LatestPrice = LatestPrice;
    }

    public String getRef() {
        return ref;
    }
}
