package com.example.laba4;


import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class SecondScreen {
    @FXML
    private Label resultLabel;
    @FXML
    private Button goToMainButton;



    @FXML
    private void handleButtonClick() {

        resultLabel.setText("Hello world");

    }

    @FXML
    public void goToMain() throws IOException {
        Parent main = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), goToMainButton.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(event -> {
            // Load settings screen

            Stage stage = (Stage) goToMainButton.getScene().getWindow();

            FadeTransition fadeIn = new FadeTransition(Duration.millis(500), main);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
            stage.setScene(new Scene(main));
        });
        fadeOut.play();


    }
}
