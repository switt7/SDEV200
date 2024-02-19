package Classes;

import Material;

public class MaterialTest {
    public static void main(String[] args) {
        Material material = new Material("Wood", 100);
        System.out.println("Material: " + material.getMaterialName() + ", Quantity: " + material.getQuantity());
    }
}