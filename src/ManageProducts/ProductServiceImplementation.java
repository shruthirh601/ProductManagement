package ManageProducts;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceImplementation implements ProductServices {
    protected HashMap<Integer, Product> products = new HashMap<>();
    protected int count = 0;
    @Override
    public void addProduct(Product product) {
        count++;
        products.put(count, product);
    }

    @Override
    public void updateProduct(String oldProductID, Product newProduct) throws NullParameterException {
        if(oldProductID == null){
            try {
                throw new NullParameterException("Parameter is null");
            } catch (NullParameterException e) {
                throw new RuntimeException(e);
            }
        }
        for(Product product : products.values()){
            if(product.productId.equals(oldProductID)){
                product.productId = newProduct.productId;
                product.productName = newProduct.productName;
                product.productPrice = newProduct.productPrice;
                product.productStock = newProduct.productStock;
            }
        }

    }

    @Override
    public void deleteProduct(String productID) {
        if(products.isEmpty()){
            try{
                throw new EmptyListException("Nothing to delete");
            }
            catch(EmptyListException e){
                throw new RuntimeException(e);
            }
        }
        if(productID == null){
            try {
                throw new NullParameterException("Parameter is null");
            } catch (NullParameterException e) {
                throw new RuntimeException(e);
            }
        }
        for(Product product : products.values()){
            if(product.productId.equals(productID)){
                products.remove(product);
            }
            else{
                try{
                    throw new EmptyListException("Nothing to show");
                }
                catch (EmptyListException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    @Override
    public Product searchProduct(String productId){
        if(products.isEmpty()){
            try{
                throw new EmptyListException("Nothing to show");
            }
            catch (EmptyListException e) {
                throw new RuntimeException(e);
            }
        }
        if(productId == null){
            try {
                throw new NullParameterException("Parameter is null");
            } catch (NullParameterException e) {
                throw new RuntimeException(e);
            }
        }
        for(Product product : products.values()){
            if(product.productId.equals(productId)){
                return product;
            }
        }
        return null;
    }

    @Override
    public void getAllProducts() {
        if(products.isEmpty()){
            try{
                throw new EmptyListException("Nothing to show");
            }
            catch (EmptyListException e) {
                throw new RuntimeException(e);
            }
        }
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Product: " + entry.getValue());
        }
    }

    @Override
    public void addToCart(String productName) {
        if(productName == null){
            try {
                throw new NullParameterException("Parameter is null");
            } catch (NullParameterException e) {
                throw new RuntimeException(e);
            }
        }
        for(Product product : products.values()){
            if(product.productName.equals(productName)){
                if(product.productStock < 0){
                    try{
                        throw new OutOfStockException("Product is out of stock, please delete the product or add to stock");
                    }
                    catch (OutOfStockException e) {
                        throw new RuntimeException(e);
                    }
                }
                product.productStock--;
            }
        }
    }

    @Override
    public void removeFromCart(String productName) {
        if(productName == null){
            try {
                throw new NullParameterException("Parameter is null");
            } catch (NullParameterException e) {
                throw new RuntimeException(e);
            }
        }
        for(Product product : products.values()){
            if(product.productName.equals(productName)){
                product.productStock++;
            }
        }
    }
}
