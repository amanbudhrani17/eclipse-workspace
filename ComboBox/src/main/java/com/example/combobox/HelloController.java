package com.example.combobox;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public ComboBox<String> comboBox;
    @FXML
    public ListView<String> listView = new ListView<>();



    ObservableList<String> list = FXCollections.observableArrayList("Aman", "Mohit", "Nitu", "Ayush", "Nisheet", "Ashmit", "Harshit");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(list);
        listView.setItems(list);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    public void button(ActionEvent event){
        ObservableList<String> names;
        names = listView.getSelectionModel().getSelectedItems();
        for (String name : names){
            System.out.println(name);
        }
    }
}