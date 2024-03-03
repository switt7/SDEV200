
 import java.sql.DriverManager;

 import javafx.geometry.HPos;
 import javafx.scene.control.Button;
 import javafx.scene.control.ComboBox;
 import javafx.scene.control.Label;
 import javafx.scene.control.TextField;
 import javafx.scene.layout.BorderPane;
 import javafx.scene.layout.GridPane;
 
 public class DBConnectionPanel extends BorderPane {
   //Initialize components
   private Label lbStatus = new Label("Not connected.");
   private Label lbJDBC = new Label("JDBC Drive");
   private Label lbURL = new Label("Database URL");
   private Label lbUser = new Label("Username");
   private Label lbPass = new Label("Password");
   private ComboBox<String> cboJDBC = new ComboBox<>();
   private ComboBox<String> cboURL = new ComboBox<>();
   private TextField tfUser = new TextField();
   private TextField tfPass = new TextField();
   private Button btnConnectToDatabase = new Button("Connect to DB");
 
   DBConnectionPanel() {}
 
   DBConnectionPanel(String JDBC, String URL) {
     cboJDBC.getItems().addAll(JDBC);
     cboJDBC.setValue(JDBC);
     cboURL.getItems().addAll(URL);
     cboURL.setValue(URL);
     
     setTop(lbStatus);
     GridPane pane = new GridPane();
     pane.add(lbJDBC, 0, 0);
     pane.add(cboJDBC, 1, 0);
     pane.add(lbURL, 0, 1);
     pane.add(cboURL, 1, 1);
     pane.add(lbUser, 0, 2);
     pane.add(tfUser, 1, 2);
     pane.add(lbPass, 0, 3);
     pane.add(tfPass, 1, 3);
     pane.add(btnConnectToDatabase, 1, 4);
     setCenter(pane);
     GridPane.setHalignment(btnConnectToDatabase, HPos.RIGHT);
     
 
 
     btnConnectToDatabase.setOnMouseClicked(e -> {
       try {
             //Load JDBC driver
             Class.forName(JDBC);
             
             //Connection
             DriverManager.getConnection(URL, 
                                         getUsername(), 
                                         getPassword());
             lbStatus.setText("Connected to " + URL);
         }
         catch (Exception ex) {
             lbStatus.setText("Connection failed.");
         }
     });
   }
 
   public String getUsername() {
     return tfUser.getText();
   }
 
   public String getPassword() {
     return tfPass.getText();
   }
 
 }