package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../views/index.fxml"));
        Scene s = new Scene(root, 1080, 720);
        s.getStylesheets().add(Main.class.getResource("../views/add.css").toExternalForm());
        primaryStage.setTitle("Papyrus");
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
