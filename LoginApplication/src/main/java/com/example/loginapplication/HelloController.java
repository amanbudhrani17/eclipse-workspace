package com.example.loginapplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.sql.*;

public class HelloController {
    public Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/budhranibrothers?useSSL=false&allowPublicKeyRetrieval=true","root","budhrani");
    public Statement stmt=connect.createStatement();
    public ResultSet resultSet;

    public HashMap<String , String> registers = new HashMap<>();
    @FXML
    private Label status;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    public HelloController() throws SQLException {
    }

    @FXML
    protected void setStatus() throws IOException, SQLException {
        boolean flag = false;
//        if (username.getText() != "" && password.getText() != "") {
//            if (registers.containsKey(username.getText())) {
//                if (registers.get(username.getText()).equals(password.getText())) {
//                    status.setText("Successfully Logged In");
//                    Stage stage = new Stage();
//                    Parent root = FXMLLoader.load(HelloApplication.class.getResource("Login.fxml"));
//                    Scene scene = new Scene(root, 550, 100);
//                    stage.setScene(scene);
//                    stage.setTitle("Main Window");
//                    stage.show();
//                } else status.setText("Password Incorrect");
//            }
//            else {
//                status.setText("User not registered please register");
//            }
//        }
//        else {
//            status.setText("Either Username or Password are empty");
//        }

        if (username.getText() != "" && password.getText() != ""){
            String q = "select username from login where username = "+'"'+username.getText()+'"';
            String r = "select password from login where username = "+'"'+username.getText()+'"';
            resultSet = stmt.executeQuery(q);

            if (resultSet.next()){
                resultSet = stmt.executeQuery(r);
                resultSet.next();
                if (resultSet.getString(1).equals(password.getText())){
                    status.setText("Successfully Logged In");
                    Stage stage = new Stage();
                    Parent root = FXMLLoader.load(HelloApplication.class.getResource("Login.fxml"));
                    Scene scene = new Scene(root, 900, 200);
                    stage.setScene(scene);
                    stage.setTitle("Main Window");
                    stage.show();
                }
                else status.setText("Password Incorrect");
            }
            else status.setText("User not registered please register");
        }
    }

    @FXML
    protected void setStatus2() throws IOException, SQLException {

//        if (username.getText() != "" && password.getText() != "") {
//            if (registers.containsKey(username.getText())) {
//                status.setText("Username already taken");
//            } else {
//                registers.put(username.getText(), password.getText());
//                status.setText("User registered successfully");
//                username.setText("");
//                password.setText("");
//            }
//        }
//        else {
//            status.setText("Either Username or Password are empty");
//
//        }

        if (username.getText() != "" && password.getText() != ""){
            String q = "select username from login where username = "+'"'+username.getText()+'"'+";";
            resultSet=stmt.executeQuery(q);
            if (resultSet.next()){
                status.setText("Username already taken");
            }
            else {
                String query = "insert into login values(" +'"'+ username.getText()+'"' + "," +'"'+ password.getText()+'"' + ");";
                stmt.executeUpdate(query);
                status.setText("User registered successfully");
                username.setText("");
                password.setText("");
            }
        }
        else status.setText("Either Username or Password are empty");
    }
}