package ManageProducts;

import java.util.Scanner;

public class ProductApp {
    static String productID;
    static String productName;
    static float productPrice;
    static int productStock;
    static Product product = new Product();

    public static void main(String[] args) throws NullParameterException {
        Scanner sc = new Scanner(System.in);
        ProductServices service = new ProductServiceImplementation();

        while(true) {
            System.out.println("Available Options for Product Management System:");
            System.out.println("1. Add Product\n2. Update Product\n3. Delete Product\n4. Search for a Product\n" +
                    "5. Show All Products\n6. Add Product to Cart \n7. Remove Product from Cart\n8. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter Product Id: ");
                    productID = sc.next();
                    System.out.println("Enter Product Name: ");
                    productName = sc.next();
                    System.out.println("Enter Product Price: ");
                    productPrice = sc.nextFloat();
                    System.out.println("Enter Product Quantity: ");
                    productStock = sc.nextInt();
                    product = new Product(productID, productName, productPrice, productStock);
                    service.addProduct(product);
                    break;
                case 2: System.out.println("Enter Product Id of item to be updated: ");
                    String oldProductId = sc.next();
                    System.out.println("Enter new Product Details: ");
                    System.out.println("Enter Product Id: ");
                    productID = sc.next();
                    System.out.println("Enter Product Name: ");
                    productName = sc.next();
                    System.out.println("Enter Product Price: ");
                    productPrice = sc.nextFloat();
                    System.out.println("Enter Product Quantity: ");
                    productStock = sc.nextInt();
                    product = new Product(productID, productName, productPrice, productStock);
                    service.updateProduct(oldProductId, product);
                    break;
                case 3:
                    System.out.println("Enter Product details of item to be deleted: ");
                    productID = sc.next();
                    service.deleteProduct(productID);
                    break;
                case 4:
                    System.out.println("Enter Product ID details of item to be searched: ");
                    productID = sc.next();
                    service.searchProduct(productID);
                    break;
                case 5: service.getAllProducts();
                    break;
                case 6: System.out.println("Enter name of Product to be added to cart:");
                        productName = sc.next();
                        service.addToCart(productName);
                        break;
                case 7: System.out.println("Enter name of Product to be added to cart:");
                        productName = sc.next();
                        service.removeFromCart(productName);
                        break;
                default: return;

            }
        }
    }
}
