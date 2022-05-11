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

    private String[] algorithmsName = {"Bailey-Borwein-Plouffe", "Spigot", "Monte Carlo"};
    private String[] stressChoice = {"50", "100", "200", "500", "1000", "2000", "5000"};


    @FXML
    public void launchButtonOnAction(ActionEvent event){
       //System.out.println(HelloApplication.class.getClassLoader().getResource("bbpLaunch.fxml"));
        String s = choiceBox.getValue();
        if(s.equals("Bailey-Borwein-Plouffe")){
            s = "bbpLaunch.fxml";
        }else if(s.equals("Spigot")){
            s = "spigotLaunch.fxml";
        }else if(s.equals("Monte Carlo")){
            s = "monteCarloLaunch.fxml";
        }
        URL adr = HelloApplication.class.getClassLoader().getResource(s);
        try {

            Parent root = FXMLLoader.load(adr);
            Stage window = (Stage) launchButton.getScene().getWindow();
            window.setScene(new Scene(root,1300,800));
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e);
            System.out.println(adr);
        }
    }

    @FXML
    public void initialize() {
        choiceBox.getItems().addAll(algorithmsName);

        speedChoiceBox.getItems().addAll(stressChoice);

    }





}