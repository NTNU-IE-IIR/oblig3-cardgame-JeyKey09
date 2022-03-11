package no.ntnu.mathijoh.cardgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    int xSize = 1000;
    int ySize = 700;


    @Override
    public void start(Stage stage) throws IOException {    

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneBuilder.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CardGame");
        stage.show();
    }
    
    /**
     * Launches the application
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

}