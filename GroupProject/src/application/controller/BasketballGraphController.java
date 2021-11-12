package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.GraphEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BasketballGraphController implements Initializable {

    @FXML
    private LineChart<?, ?> graph;
    @FXML
    private Text winnerText;
    @FXML
    private AnchorPane mainPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		int team1Pts = 0;
		int team2Pts = 0;
		// TODO Auto-generated method stub
		XYChart.Series team1 = new XYChart.Series();
        team1.setName("Team 1");        
        
        XYChart.Series team2 = new XYChart.Series();
        team2.setName("Team 2");
        
        for ( GraphEvent a : Main.GraphEvents) {
        	if ( a.getTeam().equals("Team 1")  ) {
        		team1Pts+=a.getPointDiff();
        		team1.getData().add(new XYChart.Data(String.valueOf(a.getTimeOccured()-Main.gameStartTime), team1Pts));
        		team2.getData().add(new XYChart.Data(String.valueOf(a.getTimeOccured()-Main.gameStartTime), team2Pts));
        	}
        	else {
        		team2Pts+=a.getPointDiff();
        		team1.getData().add(new XYChart.Data(String.valueOf(a.getTimeOccured()-Main.gameStartTime), team1Pts));
        		team2.getData().add(new XYChart.Data(String.valueOf(a.getTimeOccured()-Main.gameStartTime), team2Pts));
        	}
        }
        
        graph.getData().addAll(team1,team2);
        
        if ( team1Pts > team2Pts ) {
        	winnerText.setText("Team 1 Wins!");
        }
        else if ( team1Pts < team2Pts ) {
        	winnerText.setText("Team 2 Wins!");
        }
        else {
        	winnerText.setText("Tie Game!");
        }
	}
	
    @FXML
    void toHomescreen(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/Main.fxml").toURI().toURL();
		//Parent root = FXMLLoader.load(url);
        mainPane = FXMLLoader.load(url);// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

    @FXML
    void playAnother(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/Basketball.fxml").toURI().toURL();
		//Parent root = FXMLLoader.load(url);
        mainPane = FXMLLoader.load(url);// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

    
    
}
