package ManageProducts;

public interface ProductServices {
    void addProduct(Product product);
    void updateProduct(String oldProductID, Product newProduct) throws NullParameterException;
    void deleteProduct(String productID);
    Product searchProduct(String productId);
    void getAllProducts();
    void addToCart(String productName);
    void removeFromCart(String productName);
}
