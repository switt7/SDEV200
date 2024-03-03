
//Write a program that views, inserts, and updates
//staff information stored in a database, as shown in Figure 34.27a. The View button
//displays a record with a specified ID. The Insert button inserts a new record. The
//Update button updates the record for the specified ID. 

 import java.sql.*;
 import javafx.application.Application;
 import javafx.geometry.Pos;
 import javafx.scene.Scene;
 import javafx.scene.control.Button;
 import javafx.scene.control.Label;
 import javafx.scene.control.TextField;
 import javafx.scene.layout.BorderPane;
 import javafx.scene.layout.FlowPane;
 import javafx.scene.layout.HBox;
 import javafx.scene.layout.StackPane;
 import javafx.stage.Stage;
 
 public class Exercise_34_01 extends Application {
     @Override
     public void start(Stage primaryStage) {
         initializeDB();
 
         //Create Pane
         BorderPane borderPane = new BorderPane();
         StackPane statusPane = new StackPane();
         FlowPane hBoxPane = new FlowPane();
 
         //Create the container for each attribute for each line
         HBox hBoxStatus = new HBox();
         HBox hBoxID = new HBox();
         HBox hBoxName = new HBox();
         HBox hBoxAddress = new HBox();
         HBox hBoxLocation = new HBox();
         HBox hBoxTelephone = new HBox();
         HBox hBoxButtons = new HBox();
         
         //Create lables and boxes
         Label lbStatus = new Label("Add information to continue.");
         hBoxStatus.getChildren().add(lbStatus);
         Label lbID = new Label("ID");
         TextField tfID = new TextField();
         hBoxID.getChildren().addAll(lbID, tfID);
         Label lbLastName = new Label("Last Name");
         TextField tfLastName = new TextField();
         Label lbFirstName = new Label("First Name");
         TextField tfFirstName = new TextField();
         Label lbMI = new Label("MI");
         TextField tfMI = new TextField();
         hBoxName.getChildren().addAll(lbLastName, tfLastName,
             lbFirstName, tfFirstName, lbMI, tfMI);
         Label lbAddress = new Label("Address");
         TextField tfAddress = new TextField();
         hBoxAddress.getChildren().addAll(lbAddress, tfAddress);
         Label lbCity = new Label("City");
         TextField tfCity = new TextField();
         Label lbState = new Label("State");
         TextField tfState = new TextField();
         hBoxLocation.getChildren().addAll(lbCity, tfCity,
             lbState, tfState);
         Label lbTele = new Label("Telephone");
         TextField tfTele = new TextField();
         hBoxTelephone.getChildren().addAll(lbTele, tfTele);
 
         //Create the different buttons and add to paneButtons
         Button btnView = new Button("View");
         Button btnInsert = new Button("Insert");
         Button btnUpdate = new Button("Update");
         Button btnClear = new Button("Clear");
         hBoxButtons.getChildren().addAll(btnView, btnInsert,
             btnUpdate, btnClear);
         hBoxButtons.setAlignment(Pos.CENTER);
 
         //Add containers
         statusPane.getChildren().add(hBoxStatus);
         hBoxPane.getChildren().addAll(hBoxID, hBoxName,
             hBoxAddress, hBoxLocation, hBoxTelephone);
 
         //Place panes in the  borderPane
         borderPane.setTop(statusPane);
         borderPane.setCenter(hBoxPane);
         borderPane.setBottom(hBoxButtons);
 
 
         //Create the scene
         Scene scene = new Scene(borderPane);
         primaryStage.setTitle("Exercise_34_01");
         primaryStage.setScene(scene);
         primaryStage.show();
 
         //Control button clicks
         btnView.setOnMouseClicked(e -> {
             view(tfID, tfLastName, tfFirstName, tfMI, tfAddress,
             tfCity, tfState, tfTele, lbStatus);
         });
         btnInsert.setOnMouseClicked(e -> {
             insert(tfID, tfLastName, tfFirstName, tfMI, tfAddress,
             tfCity, tfState, tfTele, lbStatus);
         });
         btnUpdate.setOnMouseClicked(e -> {
             update(tfID, tfLastName, tfFirstName, tfMI, tfAddress,
             tfCity, tfState, tfTele, lbStatus);
         });
         btnClear.setOnMouseClicked(e -> {
             clear(tfID, tfLastName, tfFirstName, tfMI, tfAddress,
                 tfCity, tfState, tfTele, lbStatus);
         });
     }
 
     private void initializeDB() {
         try {
             //Load JDBC driver
             Class.forName("com.mysql.cj.jdbc.Driver");
             System.out.println("Driver loaded");
             
             //Establish connection
             DriverManager.getConnection
                 ("jdbc:mysql://localhost/javabook", "root", "");
             System.out.println("Database connected");
         }
         catch (Exception ex) {
             ex.printStackTrace();
         }
 
     }
 
     //Show the details of a staff member (specify ID)
     private void view(TextField tfID, TextField tfLastName,
         TextField tfFirstName, TextField tfMI, TextField tfAddress,
         TextField tfCity, TextField tfState, TextField tfTele, Label lbStatus) {
         try {
             //Load the JDBC driver
             Class.forName("com.mysql.cj.jdbc.Driver");
             
             //Establish the connection
             Connection connection = DriverManager.getConnection
                 ("jdbc:mysql://localhost/javabook", "root", "");
 
             //Create statement
             Statement statement = connection.createStatement();
 
             //Select columns from staff table
             ResultSet resultSet = statement.executeQuery("select *" +
                 "from staff where id = " + tfID.getText());
             
             //Results
             while (resultSet.next()) {
                 tfLastName.setText(resultSet.getString(2));
                 tfFirstName.setText(resultSet.getString(3));
                 tfMI.setText(resultSet.getString(4));
                 tfAddress.setText(resultSet.getString(5));
                 tfCity.setText(resultSet.getString(6));
                 tfState.setText(resultSet.getString(7));
                 tfTele.setText(resultSet.getString(8));
                 lbStatus.setText("Record displayed below.");
             }
         }
         catch (Exception ex) {
             lbStatus.setText("Record not found.");
         }
     }
 
     //Insert new row into table
     private void insert(TextField tfID, TextField tfLastName,
         TextField tfFirstName, TextField tfMI, TextField tfAddress,
         TextField tfCity, TextField tfState, TextField tfTele, Label lbStatus) {
             try {
                 //Load JDBC driver
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 
                 //Connection
                 Connection connection = DriverManager.getConnection
                     ("jdbc:mysql://localhost/javabook", "root", "");
     
                 //Create statement
                 Statement statement = connection.createStatement();
                 
                 //Execute update
                 statement.executeUpdate("insert into staff " +
                     "values ('" + tfID.getText() +
                     "', '" + tfLastName.getText() +
                     "', '" + tfFirstName.getText() +
                     "', '" + tfMI.getText() +
                     "', '" + tfAddress.getText() +
                     "', '" + tfCity.getText() +
                     "', '" + tfState.getText() + 
                     "', '" + tfTele.getText() +
                     "');");
                 
                 //Update status
                 lbStatus.setText("Record created.");
 
             }
             catch (Exception ex) {
                 lbStatus.setText("Incorrect format.");
                 ex.printStackTrace();
             }
     }
 
     //Update table data
     private void update(TextField tfID, TextField tfLastName,
         TextField tfFirstName, TextField tfMI, TextField tfAddress,
         TextField tfCity, TextField tfState, TextField tfTele, Label lbStatus) {
             try {
                 //Load JDBC driver
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 
                 //Establish connection
                 Connection connection = DriverManager.getConnection
                     ("jdbc:mysql://localhost/javabook", "root", "");
     
                 //Create a statement
                 Statement statement = connection.createStatement();
                 
                 // Execute update
                 statement.executeUpdate("update staff " +
                     "set lastName = '" + tfLastName.getText() +
                     "', firstName = '" + tfFirstName.getText() +
                     "', mi = '" + tfMI.getText() +
                     "', address = '" + tfAddress.getText() +
                     "', city = '" + tfCity.getText() +
                     "', state = '" + tfState.getText() +
                     "', telephone = '" + tfTele.getText() +
                     "' where id = " + tfID.getText() + ";");
                 
                 //Update status
                 lbStatus.setText("Record updated.");
 
             }
             catch (Exception ex) {
                 lbStatus.setText("Record not found, cannot be updated.");
                 ex.printStackTrace();
             }
     }
 
     //Clear textfields
     private void clear(TextField tfID, TextField tfLastName,
         TextField tfFirstName, TextField tfMI, TextField tfAddress,
         TextField tfCity, TextField tfState, TextField tfTele, Label lbStatus) {
         tfID.setText("");
         tfLastName.setText("");
         tfFirstName.setText("");
         tfMI.setText("");
         tfAddress.setText("");
         tfCity.setText("");
         tfState.setText("");
         tfTele.setText("");
         lbStatus.setText("Add information to continue.");
     }
 
     public static void main(String[] args) {
         launch(args);
     }
 }