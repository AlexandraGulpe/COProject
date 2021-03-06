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

public class spigotPageController {
    @FXML
    private Button cancelButton;

    @FXML
    private Label resultsLabel;

    @FXML
    private Label averageLabel;

    public void cancelButtonOnAction(ActionEvent event) throws Exception {
        URL adr = HelloApplication.class.getClassLoader().getResource("hello-view.fxml");
        Parent root = FXMLLoader.load(adr);
        Stage window = (Stage) cancelButton.getScene().getWindow();
        window.setScene(new Scene(root, 1300, 800));
    }

    @FXML
    public void initialize(){
        int launchSpeed = Integer.parseInt(MyChoice.getValue());
        int algoChoice = Integer.parseInt(MyChoice.getAlgoChoice());
        String resultsAsString = TestCpuDigitsOfPi.getResults(launchSpeed, algoChoice);
        resultsLabel.setText(resultsAsString);
        StoreService.appendData(algoChoice,launchSpeed, resultsAsString);
        averageLabel.setText(OurAverages.getAverages(launchSpeed,algoChoice));
    }
}
