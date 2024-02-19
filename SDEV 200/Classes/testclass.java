package Classes;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
}

public class Material {
    private String materialName;
    private int quantity;

    public Material(String materialName, int quantity) {
        this.materialName = materialName;
        this.quantity = quantity;
    }

    // Getters and Setters
}

public interface InventoryPurpose {
    void addProduct(Product product, int quantity);
    void removeProduct(Product product, int quantity);
    void addMaterial(Material material, int quantity);
    void removeMaterial(Material material, int quantity);
}

public class InventoryManagementSystem implements InventoryPurpose {
    private Map<Product, Integer> products = new HashMap<>();
    private Map<Material, Integer> materials = new HashMap<>();

    @Override
    public void addProduct(Product product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
    }

    @Override
    public void removeProduct(Product product, int quantity) {
        if (products.containsKey(product)) {
            int currentQuantity = products.get(product);
            if (currentQuantity - quantity <= 0) {
                products.remove(product);
            } else {
                products.put(product, currentQuantity - quantity);
            }
        }
    }

    @Override
    public void addMaterial(Material material, int quantity) {
        materials.put(material, materials.getOrDefault(material, 0) + quantity);
    }

    @Override
    public void removeMaterial(Material material, int quantity) {
        if (materials.containsKey(material)) {
            int currentQuantity = materials.get(material);
            if (currentQuantity - quantity <= 0) {
                materials.remove(material);
            } else {
                materials.put(material, currentQuantity - quantity);
            }
        }
    }
}
