package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import application.Main;
import application.model.GraphEvent;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class BasketballController implements Initializable {
	
	@FXML
    private AnchorPane basketballPane;
	
    @FXML
    private TextArea teamOnePoints;

    @FXML
    private TextArea teamTwoPoints;
    
    @FXML
    private ProgressBar pointComp;
    
    @FXML
    private Label timerLabel;
    
    @FXML
    private TextField enteredMinutes;
    @FXML
    private TextField enteredSeconds;
    
    private Timer myTimer;
    public int seconds = 0;
    public int minutes = 0;
    
   
    @FXML
    void addPointTeamOne(ActionEvent event) {									// This function will add points to the team value
    	String evt = event.getSource().toString();
    	int pt = -1;
    	switch ( evt.substring( evt.indexOf("]'")+2, evt.length()-1 ) ) {		// Uses the text of the buttons to determine the value of points being added.
    		case "Free Throw":
    			pt=1;
    			break;
    		case "Score":
    			pt=2;
    			break;
    		case "Three Pointer":
    			pt=3;
    			break;
    		default: 
    			System.out.println("hello");
    			break;
    	}
    	teamOnePoints.setText( Integer.toString(Integer.valueOf(teamOnePoints.getText())+pt) );
    	updatePB();
    	Date date = new Date();
    	Main.GraphEvents.add(new GraphEvent(date.getTime(), "Team 1", pt) );	// Adds an GraphEvent event to the list of GraphEvents to be used to Display scores
    }

    @FXML
    void addPointTeamTwo(ActionEvent event) {									// This function will add points to the team value
    	String evt = event.getSource().toString();
    	int pt = -1;
    	switch ( evt.substring( evt.indexOf("]'")+2, evt.length()-1 ) ) {		// Uses the text of the buttons to determine the value of points being added.
    		case "Free Throw":
    			pt=1;
    			break;
    		case "Score":
    			pt=2;
    			break;
    		case "Three Pointer":
    			pt=3;
    			break;
    		default: break;
    	}
    	teamTwoPoints.setText( Integer.toString(Integer.valueOf(teamTwoPoints.getText())+pt) );
    	updatePB();
    	Date date = new Date();
    	Main.GraphEvents.add(new GraphEvent(date.getTime(), "Team 2", pt) );	// Adds an GraphEvent event to the list of GraphEvents to be used to Display scores
    }
    
    @FXML
    void updatePB() {															// Responsible for updating the ProgressBar that gives a visual on who is winning
    	int t1Points = Integer.valueOf(teamOnePoints.getText());
    	int t2Points = Integer.valueOf(teamTwoPoints.getText());
    	if ( Integer.valueOf(teamTwoPoints.getText()) == 0 ) {
    		if ( Integer.valueOf(teamOnePoints.getText()) == 0 ) {
    			pointComp.setProgress(0.5);
    		}
    		else {
    			pointComp.setProgress(0);
    		}
    	}
    	else {
    		pointComp.setProgress( (double)t1Points/(t1Points+t2Points) );
    	}
    }
    
    
    @FXML
    void startTime(ActionEvent event) {
    	
    	//
    	//PLEASE PRESS STOP ON THE TIMER IF ITS NOT FULLY RUN OUT
    	//
    	//getting info from text fields, checking if empty or not
    	if(enteredMinutes.getText().trim().isEmpty() && enteredSeconds.getText().trim().isEmpty())
        {
        	minutes = 0;
        	seconds = 0;
        }
        
    	else if(enteredSeconds.getText().trim().isEmpty())
        {
        	seconds = 0;
        	minutes = Integer.parseInt(enteredMinutes.getText().trim());
        }
    	
    	else if(enteredMinutes.getText().trim().isEmpty())
        {
        	minutes = 0;
        	seconds = Integer.parseInt(enteredSeconds.getText().trim());
        }
    	
    	
    	else {
    		seconds = Integer.parseInt(enteredSeconds.getText().trim());
            minutes = Integer.parseInt(enteredMinutes.getText().trim());
    	}
        
        
        //making a timer
        myTimer = new Timer();
        myTimer.scheduleAtFixedRate(new TimerTask(){
        	//running timer
        	public void run() {
        		Platform.runLater(() -> {
        			//if time = 00:00, stops timer
        			if((minutes == 0) && (seconds == 0))
        			{
        				myTimer.cancel();
        			}
        			//int to string for textfield
        			String str = String.valueOf(seconds);
        			String str2 = String.valueOf(minutes);
        			
        			//adding a zero in front of digits less than 10
        			if(seconds < 10)
        			{
        				str = String.valueOf("0" + seconds);
        			}
        			if(minutes < 10)
        			{
        				str2 = String.valueOf("0" + minutes);
        			}
        			
        			//printing time to label
        			timerLabel.setText(str2 + ":" + str);
        			
        			//decrementing time
        			if((minutes != 0) && (seconds == 0))
        			{
        				seconds = 60;
        				minutes--;
        			}
        			
        			seconds--;
        			
        		});
        	}
        }, 0, 1000);

    }

    @FXML
    void stopTime(ActionEvent event) {
    	myTimer.cancel();
    }
    
    
    @FXML
    void endGame(ActionEvent event) throws IOException {						// Switches views to the BasketballGraph
    	URL url = new File("src/application/view/BasketballGraph.fxml").toURI().toURL();
        basketballPane = FXMLLoader.load(url);// pane you are GOING TO
        Scene scene = new Scene(basketballPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    void resumeButton(ActionEvent event) {
    	String timeOnBoard = timerLabel.getText().trim();
    	String[] stringarray = timeOnBoard.split(":");
    	
    	minutes = Integer.parseInt(stringarray[0]);
    	seconds = Integer.parseInt(stringarray[1]);
    	
    	
    	myTimer = new Timer();
        myTimer.scheduleAtFixedRate(new TimerTask(){
        	public void run() {
        		Platform.runLater(() -> {
        			if((minutes == 0) && (seconds == 0))
        			{
        				myTimer.cancel();
        			}
        			String str = String.valueOf(seconds);
        			String str2 = String.valueOf(minutes);
        			
        			if(seconds < 10)
        			{
        				str = String.valueOf("0" + seconds);
        			}
        			if(minutes < 10)
        			{
        				str2 = String.valueOf("0" + minutes);
        			}
        			
        			timerLabel.setText(str2 + ":" + str);
        			
        			
        			if((minutes != 0) && (seconds == 0))
        			{
        				seconds = 60;
        				minutes--;
        			}
        			
        			seconds--;
        			
        		});
        	}
        }, 0, 1000);
    }
   
    
    
    @FXML
    void backButton(ActionEvent event) throws IOException{
    	URL url = new File("src/application/view/SportsMenu.fxml").toURI().toURL();
		//Parent root = FXMLLoader.load(url);
        basketballPane = FXMLLoader.load(url);// pane you are GOING TO
        Scene scene = new Scene(basketballPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updatePB();
		Main.gameStartTime = new Date().getTime();
		Main.GraphEvents = new ArrayList<GraphEvent>();
    	System.out.println(Main.gameStartTime);
    	Main.GraphEvents.add(new GraphEvent(Main.gameStartTime, "Team 1", 0) );
    	Main.GraphEvents.add(new GraphEvent(Main.gameStartTime, "Team 2", 0) );
		
	}
    
    

}
