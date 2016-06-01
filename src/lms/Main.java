package lms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by 985176 on 5/31/2016.
 */


public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
        primaryStage.setTitle("Library Management System");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
      //  scene.getStylesheets().add(getClass().getResource("css/Login.css").toExternalForm());
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
