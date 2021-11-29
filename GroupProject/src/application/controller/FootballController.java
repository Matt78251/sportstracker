//worked on by Clyde Harris
package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.application.Platform;


public class FootballController {
	private int H_score=0;
	private int A_score=0;
	private int yards;
	private int down= 1;
	private int toFirst = 10;
	private int toTouch;
     Random rand = new Random();
    private Timer myTimer;
    public int seconds = 0;
    public int minutes = 0;
    private int q=0;
    
	@FXML
	private AnchorPane mainPane;
	
	@FXML
	private CheckBox homeBall;
	
	@FXML
	private CheckBox awayBall;
	
	@FXML
	private TextArea Ascore;
	
	@FXML
	private TextArea Hscore;
	
	@FXML
	private TextField quarter;
	
	@FXML
	private Button advance;
	
	@FXML
	private Button kickoff;
	
	@FXML
	private TextField distance;
	
	@FXML
	private TextField YardsAdvance;
	
	@FXML
	private TextField DownDistance;
	
	@FXML
	private TextField Down;
	
	@FXML
    private Label timerLabel;
    
    @FXML
    private TextField enteredMinutes;
    
    @FXML
    private TextField enteredSeconds;
	
	@FXML
	public void HomeTouchdown(ActionEvent event) throws IOException {
		H_score = H_score+6;
		Hscore.setText(Integer.toString(H_score));
	
	}
	public void AwayTouchdown(ActionEvent event) throws IOException {
		A_score = A_score+6;
		Ascore.setText(Integer.toString(A_score));
	
	}
	
	public void HomeFG(ActionEvent event) throws IOException {
		H_score = H_score+3;
		Hscore.setText(Integer.toString(H_score));
	
	}
	
	public void AwayFG(ActionEvent event) throws IOException {
		A_score = A_score+3;
		Ascore.setText(Integer.toString(A_score));
	
	}
	
	public void HomeCon(ActionEvent event) throws IOException {
		H_score = H_score+2;
		
		Hscore.setText(Integer.toString(H_score));
	}
	
	public void AwayCon(ActionEvent event) throws IOException {
		A_score = A_score+2;
		Ascore.setText(Integer.toString(A_score));
	
	}
	
	public void Kick(ActionEvent event) throws IOException{
		yards= (int)(Math.random() *50+50);
		
		distance.setText(Integer.toString(yards));
		
	}
	
	public void advance(ActionEvent event) throws IOException{
	yards = Integer.parseInt(YardsAdvance.getText());
	toTouch = Integer.parseInt(distance.getText());
	toTouch -=yards;
		toFirst = Integer.parseInt(DownDistance.getText());
		toFirst -= yards;
		DownDistance.setText(Integer.toString(toFirst));
		down++;
		if(toFirst<0) {
			toFirst = 10;
			down=1;
		}
			if(down>4) {
				down=1;	
				toFirst = 10;
			}
			Down.setText(Integer.toString(down));
			DownDistance.setText(Integer.toString(toFirst));
	
		distance.setText(Integer.toString(toTouch));
		if(toTouch<=0) {
			distance.setText(Integer.toString(0));	
		}
		if(toTouch>=99) {
			distance.setText(Integer.toString(99));	
		}
		
	}
	
	
	 @FXML
	    void startTime(ActionEvent event) {
			if(q==4) {
				if(H_score>A_score) {
				timerLabel.setText("Game Over, Home Team Wins!!");
				}
				else if(H_score==A_score) {
					timerLabel.setText("Game Over, Its a Draw!!");

					
				}
				else {
					timerLabel.setText("Game Over, Away Team Wins!!");
				}
				q=1;
			
			}
			else {	
				
				
			
		 q++;
		 quarter.setText(Integer.toString(q));
			
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
	        				q++;
	        				 quarter.setText(Integer.toString(q));
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
         mainPane = FXMLLoader.load(url);// pane you are GOING TO
         Scene scene = new Scene(mainPane);// pane you are GOING TO show
         Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
         window.setScene(scene);
         window.show();
     }
     
}