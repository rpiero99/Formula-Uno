package it.unicam.cs.pa2021.formulaUno;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class AppJavaFx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/formula1.fxml")));

        primaryStage.setTitle("FORMULA UNO");
        primaryStage.setScene(new Scene(root,200, 200));
        primaryStage.show();
    }
}
