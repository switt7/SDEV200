import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventoryPurpose extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ingredients on hand");

        ListView<String> ingredientList = new ListView<>();
        ingredientList.getItems().addAll("Butter", "Flour", "Sugar");

        VBox vbox = new VBox(ingredientList);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
