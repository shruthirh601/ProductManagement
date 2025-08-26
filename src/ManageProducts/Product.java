package ManageProducts;

public class Product {
    protected String productId;
    protected String productName;
    protected float productPrice;
    protected int productStock;

    public Product() {

    }
    public Product(String productId, String productName, float productPrice, int productStock) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    @Override
    public String toString() {
        return "Product ID:"+productId+"\nProduct Name:"+productName+"\nProduct Price:"+productPrice+"\nProduct Stock:"+productStock;
    }
}
