package com.example.coproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private ChoiceBox<String> speedChoiceBox;

    @FXML
    private Button launchButton;

    private String[] algorithmsName = {"Bailey-Borwein-Plouffe", "Spigot", "Leibnitz"};
    private String[] stressChoice = {"50", "100", "200", "500", "1000", "2000", "5000"};


    @FXML
    public void launchButtonOnAction(ActionEvent event) throws Exception{
       //System.out.println(HelloApplication.class.getClassLoader().getResource("bbpLaunch.fxml"));
        String s = choiceBox.getValue();
        if(s.equals("Bailey-Borwein-Plouffe")){
            s = "bbpLaunch.fxml";
        }else if(s.equals("Spigot")){
            s = "spigotLaunch.fxml";
        }else if(s.equals("Leibnitz")){
            s = "leibnitzLaunch.fxml";
        }
        URL adr = HelloApplication.class.getClassLoader().getResource(s);
        String algoChoice = choiceBox.getValue();
        String speedChoice = speedChoiceBox.getValue();
        if(algoChoice!=null  && speedChoice!=null) {
            MyChoice.setAlgoChoice(choiceBox.getValue());
            MyChoice.setValue(speedChoiceBox.getValue());
            Parent root = FXMLLoader.load(adr);
            Stage window = (Stage) launchButton.getScene().getWindow();
            window.setScene(new Scene(root, 1300, 800));
        }

    }

    @FXML
    public void initialize() {
        choiceBox.getItems().addAll(algorithmsName);
        speedChoiceBox.getItems().addAll(stressChoice);

    }





}