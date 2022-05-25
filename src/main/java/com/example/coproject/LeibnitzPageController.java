package com.example.coproject;

import com.example.coproject.testbench.TestCpuDigitsOfPi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;

public class LeibnitzPageController {
    @FXML
    private Button cancelButton;

    @FXML
    private Label resultsLabel;

    public void cancelButtonOnAction(ActionEvent event) throws Exception {
        URL adr = HelloApplication.class.getClassLoader().getResource("hello-view.fxml");

        Parent root = FXMLLoader.load(adr);
        Stage window = (Stage) cancelButton.getScene().getWindow();
        window.setScene(new Scene(root, 1300, 800));
    }

    @FXML
    public void initialize(){
        int launchSpeed = Integer.parseInt(MyChoice.getValue());
        int algoSpeed = Integer.parseInt(MyChoice.getAlgoChoice());
        resultsLabel.setText("Congratulations, your CPU obtained a score of: " + TestCpuDigitsOfPi.getResults(launchSpeed, algoSpeed));
    }
}
