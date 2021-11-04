package application.controller;

import java.util.Timer;

import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GenericController {
	
    @FXML
    private TextArea teamOnePoints;

    @FXML
    private TextArea teamTwoPoints;
    
    @FXML
    private ProgressBar pointComp;
    
    public int pointVal = 2;
    
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
    void addPointTeamOne(ActionEvent event) {
    	teamOnePoints.setText( Integer.toString(Integer.valueOf(teamOnePoints.getText())+pointVal) );
    	updatePB();
    }

    @FXML
    void addPointTeamTwo(ActionEvent event) {
    	teamTwoPoints.setText( Integer.toString(Integer.valueOf(teamTwoPoints.getText())+pointVal) );
    	updatePB();
    }
    
    @FXML
    void updatePB() {
    	int t1Points = Integer.valueOf(teamOnePoints.getText());
    	int t2Points = Integer.valueOf(teamTwoPoints.getText());
    	
    	System.out.println("" + t1Points + " " + t2Points);
    	
    	if ( Integer.valueOf(teamTwoPoints.getText()) == 0 ) {
    		pointComp.setProgress(0);
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
    

}
