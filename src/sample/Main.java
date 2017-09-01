package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;


public class Main extends Application  implements EventHandler<ActionEvent>{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Wisdom Arena");
        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void handle(ActionEvent event) {
//        System.out.print("this fukng working");
    }
}
