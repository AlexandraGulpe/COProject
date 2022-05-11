package com.example.coproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;

public class monteCarloPageController {
    @FXML
    private Button cancelButton;

    public void cancelButtonOnAction(ActionEvent event) throws Exception {
        URL adr = HelloApplication.class.getClassLoader().getResource("hello-view.fxml");

        Parent root = FXMLLoader.load(adr);
        Stage window = (Stage) cancelButton.getScene().getWindow();
        window.setScene(new Scene(root, 1300, 800));
    }
}
