package com.example.treeview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TreeView<String> treeView;
    Image icon = new Image(getClass().getResourceAsStream("Pr9Me.png"));
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> root = new TreeItem<>("root", new ImageView(icon));
        root.setExpanded(true);
        TreeItem<String> nodeA = new TreeItem<>("nodeA", new ImageView(icon));
        TreeItem<String> nodeB = new TreeItem<>("nodeB", new ImageView(icon));
        TreeItem<String> nodeC = new TreeItem<>("nodeC", new ImageView(icon));
        TreeItem<String> nodeA1 = new TreeItem<>("nodeA1", new ImageView(icon));
        TreeItem<String> nodeA2 = new TreeItem<>("nodeA2", new ImageView(icon));
        TreeItem<String> nodeA3 = new TreeItem<>("nodeA3", new ImageView(icon));
        TreeItem<String> nodeB1 = new TreeItem<>("nodeB1", new ImageView(icon));
        TreeItem<String> nodeB2 = new TreeItem<>("nodeB2", new ImageView(icon));
        TreeItem<String> nodeB3 = new TreeItem<>("nodeB3", new ImageView(icon));
        TreeItem<String> nodeC1 = new TreeItem<>("nodeC1", new ImageView(icon));
        TreeItem<String> nodeC2 = new TreeItem<>("nodeC2", new ImageView(icon));
        TreeItem<String> nodeC3 = new TreeItem<>("nodeC3", new ImageView(icon));

        root.getChildren().addAll(nodeA,nodeB,nodeC);
        nodeA.getChildren().addAll(nodeA1,nodeA2,nodeA3);
        nodeB.getChildren().addAll(nodeB1,nodeB2,nodeB3);
        nodeC.getChildren().addAll(nodeC1,nodeC2,nodeC3);
        treeView.setRoot(root);
    }
    public void mouseClicked(MouseEvent event){
        if(event.getClickCount()==2) {
            TreeItem<String> Item = treeView.getSelectionModel().getSelectedItem();
            System.out.println(Item.getValue());
        }
    }
}