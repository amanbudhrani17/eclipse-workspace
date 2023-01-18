package com.example.emailadministrationproject;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Next implements Initializable{
    @FXML
    Label Info;
    public Email email;
    public void setEmail(Email email2){

        email = email2;
        Info.setText(email2.getInfo());
    }
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Label correct;
    @FXML
    private TextField get;
    ObservableList<String> list = FXCollections.observableArrayList("Change Password","Set Mail Capacity","Set Alternate Email");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(list);
    }
    @FXML
    protected void setComboBox() throws IOException{
        if (get.getText().equals("")){
            correct.setText("Below field cannot be empty");
            return;
        }
        try {
            if (comboBox.getValue().equals("Change Password")) {
                email.setPassword(get.getText());
            } else if (comboBox.getValue().equals("Set Mail Capacity")) {
                try {
                    int m = Integer.parseInt(get.getText());
                    email.setMailCapacity(m);
                } catch (Exception e) {
                    correct.setText("Please Enter Integer Value");
                }
            } else if (comboBox.getValue().equals("Set Alternate Email")) {
                email.setAlternateEmail(get.getText());
            } else {
                correct.setText("Please choose one from the below list");
            }
        }catch (Exception e){
            correct.setText("Please choose one from the below list");
        }
        Info.setText(email.getInfo());
    }

}

