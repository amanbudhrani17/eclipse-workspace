package com.example.fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Button btn = new Button("Click");
//        Button exit = new Button(("Exit"));
//        exit.setOnAction(e -> System.exit(0));
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("exi");
//            }
//        });
//        VBox root = new VBox();
//        root.getChildren().addAll(btn, exit);
////        root.getChildren().add(exit);
//        Scene scene = new Scene(root, 320, 240);
//        stage.setTitle("By");
//        stage.setScene(scene);
//        stage.show();
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 320, 240);
        scene.getStylesheets().add(getClass().getResource("hello-styling.css").toExternalForm());
        stage.setTitle("My Project");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}