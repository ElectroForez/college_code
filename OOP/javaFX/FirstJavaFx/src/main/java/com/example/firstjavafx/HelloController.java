package com.example.firstjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField myTextField;

    @FXML
    private Button showDateTimeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    protected void showDateTime(ActionEvent event) {
        System.out.println("Button clicked!");
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");

        String dateTimeString = df.format(now);

        myTextField.setText(dateTimeString);
    }

}