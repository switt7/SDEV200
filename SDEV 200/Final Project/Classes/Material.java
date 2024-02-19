package Classes;

//generate the different materials used in inventory by name and quantity//
public class Material {
    private String name;
    private int quantity;

    //Get the material name//
    public String getName() {
        return name;
    }

    //Get quantity of materials//
    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

