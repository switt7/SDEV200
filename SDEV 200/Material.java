import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Material extends Application {

    private ObservableList<String> materials = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Material Quantity Input");

        ListView<String> materialListView = new ListView<>(materials);
        TextField materialNameInput = new TextField();
        TextField quantityInput = new TextField();
        Button addButton = new Button("Add");
        Button removeButton = new Button("Remove");

        addButton.setOnAction(e -> {
            String material = materialNameInput.getText() + " - Quantity: " + quantityInput.getText();
            materials.add(material);
            materialNameInput.clear();
            quantityInput.clear();
        });

        removeButton.setOnAction(e -> {
            String selectedMaterial = materialListView.getSelectionModel().getSelectedItem();
            materials.remove(selectedMaterial);
        });

        VBox root = new VBox(materialNameInput, quantityInput, addButton, removeButton, materialListView);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
