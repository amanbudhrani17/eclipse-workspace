package com.example.filechooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class HelloController {
    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private ListView listView;

    @FXML
    protected void onButton1(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("D:\\"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile!=null){
            listView.getItems().add(selectedFile.getAbsolutePath());
        }
        else {
            System.out.println("File is not valid");
        }
    }

    @FXML
    protected void onButton2(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("D:\\"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
        List<File> selectedFiles = fc.showOpenMultipleDialog(null);
        if (selectedFiles!=null){
            for (int i = 0; i<selectedFiles.size(); i++) {
                listView.getItems().add(selectedFiles.get(i).getAbsolutePath());
            }
        }
        else {
            System.out.println("File is not valid");
        }
    }
}