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

public class MainController {
	
	//comment for an edit
	
	//additional comment
	
	// comment lol
	
	@FXML
    private AnchorPane mainPane;
	
    @FXML
    void handleSecondView(ActionEvent event) throws IOException {							//Handles the event where user wants to go to the ThirdView (aka Classifieds)
    	URL url = new File("src/application/view/Basketball.fxml").toURI().toURL();
		//Parent root = FXMLLoader.load(url);
        mainPane = FXMLLoader.load(url);// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

}
