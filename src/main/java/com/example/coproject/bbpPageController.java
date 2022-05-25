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

import java.io.IOException;
import java.net.URL;


public class bbpPageController {
    @FXML
    private Button cancelButton;

    @FXML
    private Label averageLabel;


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
        int algoChoice = Integer.parseInt(MyChoice.getAlgoChoice());
        String resultAsString = TestCpuDigitsOfPi.getResults(launchSpeed, algoChoice);
        resultsLabel.setText(resultAsString);
        StoreService.appendData(algoChoice,launchSpeed,resultAsString);
        averageLabel.setText(OurAverages.getAverages(launchSpeed,algoChoice));
    }





}
