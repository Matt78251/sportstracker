package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SoccerController {
	
	
	
	@FXML
    private TextField teamAName;

    @FXML
    private TextField teamAPoints;
    
    @FXML
    private Label teamAWin;

    @FXML
    private TextField teamBName;
    
    @FXML
    private TextField teamBPoints;
    
    @FXML
    private Label teamBWin;
    
    @FXML
    private TextField period;
    
    @FXML
    private Button periodBut;

    @FXML
    private AnchorPane soccerPane;
    
    public int teamAScore = 0;
    public int teamBScore = 0;
    public int periodNum = 1;
    
    @FXML
    private Label timerLabel;
    
    @FXML
    private TextField enteredMinutes;
    @FXML
    private TextField enteredSeconds;
    
    private Timer myTimer;
    public int seconds = 0;
    public int minutes = 0;
    
    ArrayList<Integer> teamAarr1 = new ArrayList<Integer>();
    ArrayList<Integer> teamBarr1 = new ArrayList<Integer>();
    
    @FXML
    void addAGoal(ActionEvent event) {
    	teamAScore++;
    	String strA = String.valueOf(teamAScore);  
    	teamAPoints.setText(strA);
    	teamAarr1.add(teamAScore);
    }

    @FXML
    void addBGoal(ActionEvent event) {
    	teamBScore++;
    	String strB = String.valueOf(teamBScore);  
    	teamBPoints.setText(strB);
    	teamBarr1.add(teamBScore);
    }
    
    @FXML
    void nextPeriodButton(ActionEvent event) {
    	periodNum++;
    	if(periodNum > 4)
    	{
    		//team a wins
    		if(teamAScore > teamBScore)
    		{
    			teamAWin.setOpacity(1);
    		}
    		//team b wins
    		if(teamBScore > teamAScore)
    		{
    			teamBWin.setOpacity(1);
    		}
    	}
    	
    	if(periodNum == 4)
    	{
    		periodBut.setText("End Game");
    	}
    	
    	if(periodNum <= 4)
    	{
    		String strP = String.valueOf(periodNum);  
    		period.setText(strP);
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
	
	
	
	@FXML
    void backButton(ActionEvent event) throws IOException{
    	URL url = new File("src/application/view/SportsMenu.fxml").toURI().toURL();
		//Parent root = FXMLLoader.load(url);
        soccerPane = FXMLLoader.load(url);// pane you are GOING TO
        Scene scene = new Scene(soccerPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

}
