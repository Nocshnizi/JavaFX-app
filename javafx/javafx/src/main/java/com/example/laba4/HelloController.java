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

public class HelloController {
    @FXML
    private Label resultLabel;
    @FXML
    private TextField textField;

    @FXML
    private TextField textField2;

    @FXML
    private Button goToSettingsButton;

    private DatabaseHandler dbHandler = new DatabaseHandler();

    @FXML
    private void handleButtonClick() {

        String inputText = textField.getText();
        String inputAgeText = textField2.getText();
        resultLabel.setText("your name: " + inputText + "   your age: " + inputAgeText);
        dbHandler.saveUserData(inputText);
    }

    @FXML
    public void goToSettings() throws IOException {
        Parent SecondScreen = FXMLLoader.load(getClass().getResource("second_screen.fxml"));
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), goToSettingsButton.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(event -> {
            // Load settings screen

            Stage stage = (Stage) goToSettingsButton.getScene().getWindow();

            FadeTransition fadeIn = new FadeTransition(Duration.millis(500), SecondScreen);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
            stage.setScene(new Scene(SecondScreen));
        });
        fadeOut.play();
    }
}