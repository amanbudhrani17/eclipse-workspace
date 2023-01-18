package com.example.fx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

public class HelloController {
    public int i = 0;
    @FXML
//    private Label welcomeText;
    private Label myMessage, getMyMessage;

    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
    protected void setMyMessage() {
        Random rand = new Random();
        i = rand.nextInt(50);
        myMessage.setText(Integer.toString(i));
    }
    @FXML
    protected void setMyMessages(){
        Random rand = new Random();
        getMyMessage.setText(Integer.toString(rand.nextInt(50)));
    }
}