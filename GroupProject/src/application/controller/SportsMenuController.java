package application.controller;

import java.io.File;
import java.io.IOException;

import javafx.scene.layout.AnchorPane;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class SportsMenuController {
	
	
	@FXML
    private AnchorPane menuPane;

    @FXML
    void basketballButton(ActionEvent event) throws IOException {
    	
    	URL url = new File("src/application/view/Basketball.fxml").toURI().toURL();
		//Parent root = FXMLLoader.load(url);
        menuPane = FXMLLoader.load(url);// pane you are GOING TO
        Scene scene = new Scene(menuPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();

    }

    @FXML
	void footballButton(ActionEvent event) throws IOException{
    	
    	URL url = new File("src/application/view/Football.fxml").toURI().toURL();
		//Parent root = FXMLLoader.load(url);
        menuPane = FXMLLoader.load(url);// pane you are GOING TO
        Scene scene = new Scene(menuPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();

	}

	@FXML
    void golfButton(ActionEvent event) throws IOException{
		URL url = new File("src/application/view/Golf.fxml").toURI().toURL();
		//Parent root = FXMLLoader.load(url);
        menuPane = FXMLLoader.load(url);// pane you are GOING TO
        Scene scene = new Scene(menuPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();

    }

    @FXML
    void hockeyButton(ActionEvent event) throws IOException{
    	URL url = new File("src/application/view/Hockey.fxml").toURI().toURL();
		//Parent root = FXMLLoader.load(url);
        menuPane = FXMLLoader.load(url);// pane you are GOING TO
        Scene scene = new Scene(menuPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    	
    }
    
    @FXML
    void soccerButton(ActionEvent event) throws IOException{
    	URL url = new File("src/application/view/Soccer.fxml").toURI().toURL();
		//Parent root = FXMLLoader.load(url);
        menuPane = FXMLLoader.load(url);// pane you are GOING TO
        Scene scene = new Scene(menuPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    	
    }

}

	
	


