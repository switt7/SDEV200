import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Product extends Application {

    private ObservableList<String> products = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Product List App");

        ListView<String> productList = new ListView<>(products);
        TextField productInput = new TextField();
        Button addButton = new Button("Add Product");
        Button removeButton = new Button("Remove Product");

        addButton.setOnAction(e -> {
            String newProduct = productInput.getText();
            if (!newProduct.isEmpty()) {
                products.add(newProduct);
                productInput.clear();
            }
        });

        removeButton.setOnAction(e -> {
            String selectedProduct = productList.getSelectionModel().getSelectedItem();
            if (selectedProduct != null) {
                products.remove(selectedProduct);
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(productList, productInput, addButton, removeButton);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
