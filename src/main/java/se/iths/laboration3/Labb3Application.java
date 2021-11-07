package se.iths.laboration3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Labb3Application extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Labb3Application.class.getResource("labb3-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 730, 600);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("stylesheet.css")));
        stage.setTitle("Let Your Imagination Run Wild!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch();}
}
