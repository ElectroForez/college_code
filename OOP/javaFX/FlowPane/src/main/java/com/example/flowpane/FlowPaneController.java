package com.example.flowpane;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FlowPaneController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}