package Classes;

import InventoryPurpose;

public class InventoryPurposeTest {
    public static void main(String[] args) {
        InventoryPurpose purpose = new InventoryPurpose("Manufacturing");
        System.out.println("Purpose: " + purpose.getPurpose());
    }
}