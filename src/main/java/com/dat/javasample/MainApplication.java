package com.dat.javasample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/dat/javasample/DemoMain.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Samples JavaFX");
        stage.getIcons().add(new Image(String.valueOf(MainApplication.class.getResource("/com/dat/javasample/images/MainIcon.png"))));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}