package Classes;

import InventoryManagementSystem;
import InventoryPurpose;
import Material;
import Product;

public class InventoryManagementSystemTest {
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Product product = new Product("Table", 100.0);
        Material material = new Material("Metal", 50);
        InventoryPurpose purpose = new InventoryPurpose("Storage");

        ims.addProduct(product);
        ims.addMaterial(material);
        ims.setPurpose(purpose);

        // Other test scenarios for inventory management system
    }
}