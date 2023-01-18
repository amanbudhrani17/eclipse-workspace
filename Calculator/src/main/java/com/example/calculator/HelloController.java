package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.security.PrivateKey;

public class HelloController {
    @FXML
    private Label result;
    private double n1 = 0;
    public String operator = "";
    private boolean start = true;
    @FXML
    public void processNumber(ActionEvent event){
        if (start){
            result.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        result.setText(result.getText()+value);
    }
    @FXML
    public void processOperator(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if (!value.equals("=")){
            if (!operator.isEmpty()){
                return;
            }
            else {
                operator = value;
                n1 = Double.parseDouble(result.getText());
                result.setText("");
            }
        }
        else {
            if (operator.isEmpty()){
                return;
            }
            else {
                double n2 = Double.parseDouble(result.getText());
                double output = Model.model((float) n1, (float) n2,operator);
                if (output!=Integer.MAX_VALUE) {
                    result.setText(String.valueOf(output));
                    n1 = Double.parseDouble(result.getText());
                }
                else {
                    result.setText("ERROR");
                }
                operator = "";
                start = true;
            }
        }

    }
}