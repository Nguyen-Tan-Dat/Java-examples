package com.dat.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class DemoMainController {
    public BorderPane root;

    public void loadPage1() {
        loadPage("/com/dat/javasample/hello-view.fxml");
    }

    public void loadPage2() {
        loadPage("/com/dat/javasample/DemoCircleAnimation.fxml");
    }
    private void loadPage(String name){
        FXMLLoader loader=new FXMLLoader(DemoMainController.class.getResource(name));
        try {
            root.setCenter(loader.load());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
