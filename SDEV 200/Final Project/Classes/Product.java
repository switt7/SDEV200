package Classes;

//Generate the different products and manage product data through the inventory system// 
public class Product {
    private String name;
    private int quantity;

    //product name//
    public String getName() {
        return name;
    }

    //product quantity//
    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPrice'");
    }
}
