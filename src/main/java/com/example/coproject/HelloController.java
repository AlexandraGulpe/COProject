package com.example.coproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private ChoiceBox<String> speedChoiceBox;

    @FXML
    private Button launchButton;

    private String[] algorithmsName = {"Bailey-Borwein-Plouffe", "Spigot", "Monte Carlo"};
    private String[] stressChoice = {"50", "100", "200", "500", "1000", "2000", "5000"};



    public void launchButtonOnAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("bbpLaunch.fxml"));

        Stage window = (Stage) launchButton.getScene().getWindow();
        window.setScene(new Scene(root,1300,800));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(algorithmsName);
        //speedChoiceBox.getItems().addAll(stressChoice);

    }



}