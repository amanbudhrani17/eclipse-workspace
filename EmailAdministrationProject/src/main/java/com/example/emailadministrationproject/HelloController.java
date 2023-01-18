package com.example.emailadministrationproject;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label Info;
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    public HelloController() {
    }
    @FXML
    public ComboBox<String> comboBox;

    public Email email;
    ObservableList<String> list = FXCollections.observableArrayList("Development","Sales","Accounting");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(list);
    }
    @FXML
    protected void getInfo() throws IOException {
        email = new Email(firstName.getText(),lastName.getText(),comboBox.getValue());
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("next.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage =new Stage();
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//        Info.setText(email.getInfo());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("next.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Next controller = loader.getController();
        controller.setEmail(email);
        Stage stage = new Stage();
        stage.setTitle("Budhrani Brothers");
        stage.setScene(scene);
        stage.show();
        return;
    }


}


