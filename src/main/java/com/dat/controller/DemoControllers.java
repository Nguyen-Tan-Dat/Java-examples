package com.dat.controller;

import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class DemoControllers implements Initializable {
    @FXML
    private ComboBox<String> comboBoxSelect=new ComboBox<>();
    public Text outputText;
    public AnchorPane root;
    public Circle c1,c2,c3;
    private final ObservableList<String> listSelect= FXCollections.observableArrayList("Hello", "Bye", "Good morning");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxSelect.setItems(listSelect);
        comboBoxSelect.setValue(listSelect.get(0));
        rotateTransition1=setRotate(c1,true,145,24);
        rotateTransition2=setRotate(c2,false,200,18);
        rotateTransition3=setRotate(c3,true,360,10);
    }

    public void showSelect() {
        outputText.setText(comboBoxSelect.getValue());
    }

    private RotateTransition rotateTransition1,rotateTransition2,rotateTransition3;
    private RotateTransition setRotate(Circle circle,boolean reverse,int angle,int duration) {
        RotateTransition rt=new RotateTransition(Duration.seconds(duration),circle);
        rt.setAutoReverse(reverse);
        rt.setByAngle(angle);
        rt.setDelay(Duration.seconds(0));
        rt.setRate(3);
        rt.setCycleCount(5);
        return rt;
    }
    public void play(){
        rotateTransition1.play();
        rotateTransition2.play();
        rotateTransition3.play();
    }

    public void stop() {
        rotateTransition1.stop();
        rotateTransition2.stop();
        rotateTransition3.stop();
    }
}
