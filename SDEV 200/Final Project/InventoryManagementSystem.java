import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventoryManagementSystem extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        
        // Sample data from InventoryPurpose, Material, and Product classes
        String productName = "Product A";
        int quantityOnHand = 100;
        int quantityNeededToPurchase = 50;
        
        Label productInfo = new Label("Product " + productName + "\n" +
                                      "Quantity on Hand: " + quantityOnHand + "\n" +
                                      "Quantity Needed to Purchase: " + quantityNeededToPurchase);
        
        root.getChildren().add(productInfo);
        
        Scene scene = new Scene(root, 300, 200);
        
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
