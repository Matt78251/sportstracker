package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FootballController {

    @FXML
    private AnchorPane footBallPane;
    
    @FXML
    void backButton(ActionEvent event) throws IOException{
    	URL url = new File("src/application/view/SportsMenu.fxml").toURI().toURL();
		//Parent root = FXMLLoader.load(url);
        footBallPane = FXMLLoader.load(url);// pane you are GOING TO
        Scene scene = new Scene(footBallPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

}