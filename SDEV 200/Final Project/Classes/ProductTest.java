package Classes;

import Product;

public class ProductTest {
    public static void main(String[] args) {
        Product product = new Product("Sugar", 10.0);
        System.out.println("Product: " + product.getName() + ", Price: $" + product.getPrice());
    }
}