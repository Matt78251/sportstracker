package application.controller;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GolfController {

    @FXML
    private AnchorPane golfPane;
    
    
    @FXML
    private Label whoWins;
    
    @FXML
    private PieChart pieChart;
    
    //player 1 stuff
    @FXML
    private TextField player1Name;
    @FXML
    private TextField p1h1;
    @FXML
    private TextField p1h2;
    @FXML
    private TextField p1h3;
    @FXML
    private TextField p1h4;
    @FXML
    private TextField p1h5;
    @FXML
    private TextField p1h6;
    @FXML
    private TextField p1h7;
    @FXML
    private TextField p1h8;
    @FXML
    private TextField p1h9;
    @FXML
    private TextField p1Total;
    
    //player 2 stuff
    @FXML
    private TextField player2Name;
    @FXML
    private TextField p2h1;
    @FXML
    private TextField p2h2;
    @FXML
    private TextField p2h3;
    @FXML
    private TextField p2h4;
    @FXML
    private TextField p2h5;
    @FXML
    private TextField p2h6;
    @FXML
    private TextField p2h7;
    @FXML
    private TextField p2h8;
    @FXML
    private TextField p2h9;
    @FXML
    private TextField p2Total;
    
    //player 3 stuff
    @FXML
    private TextField player3Name;
    @FXML
    private TextField p3h1;
    @FXML
    private TextField p3h2;
    @FXML
    private TextField p3h3;
    @FXML
    private TextField p3h4;
    @FXML
    private TextField p3h5;
    @FXML
    private TextField p3h6;
    @FXML
    private TextField p3h7;
    @FXML
    private TextField p3h8;
    @FXML
    private TextField p3h9;
    @FXML
    private TextField p3Total;
    
    //player 4 stuff
    @FXML
    private TextField player4Name;
    @FXML
    private TextField p4h1;
    @FXML
    private TextField p4h2;
    @FXML
    private TextField p4h3;
    @FXML
    private TextField p4h4;
    @FXML
    private TextField p4h5;
    @FXML
    private TextField p4h6;
    @FXML
    private TextField p4h7;
    @FXML
    private TextField p4h8;
    @FXML
    private TextField p4h9;
    @FXML
    private TextField p4Total;
    
    
    @FXML
    void backButton(ActionEvent event) throws IOException{
    	URL url = new File("src/application/view/SportsMenu.fxml").toURI().toURL();
		//Parent root = FXMLLoader.load(url);
        golfPane = FXMLLoader.load(url);// pane you are GOING TO
        Scene scene = new Scene(golfPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    void totalsButton(ActionEvent event) {
    	zeroCheck();
    	player1Total();
    	player2Total();
    	player3Total();
    	player4Total();
    	
    	int p1total = Integer.parseInt(p1Total.getText().trim());
    	int p2total = Integer.parseInt(p2Total.getText().trim());
    	int p3total = Integer.parseInt(p3Total.getText().trim());
    	int p4total = Integer.parseInt(p4Total.getText().trim());
    	
    	//setting names equal to Player_ if not filled in by user
    	if(player1Name.getText().trim().equals(""))
    	{
    		player1Name.setText("Player 1");
    	}
    	if(player2Name.getText().trim().equals(""))
    	{
    		player2Name.setText("Player 2");
    	}
    	if(player3Name.getText().trim().equals(""))
    	{
    		player3Name.setText("Player 3");
    	}
    	if(player4Name.getText().trim().equals(""))
    	{
    		player4Name.setText("Player 4");
    	}
    	
    	int playerCount = noPlayer();
    	
    	
    	
    	if (playerCount == 1)
    	{
    		//only 1 player, therefore only player 1 could win
    		whoWins.setText(player1Name.getText().trim() + " wins!");
    		
    		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
        			new PieChart.Data(player1Name.getText().trim(), p1total));
        	pieChart.setData(pieChartData);
    	}
    	
    	
    	
    	if(playerCount == 2)
    	{
    		//player 1 won
    		if(p1total < p2total)
        	{
        		whoWins.setText(player1Name.getText().trim() + " wins!");
        	}
        	//player 2 won
        	else if(p2total < p1total)
        	{
        		whoWins.setText(player2Name.getText().trim() + " wins!");
        	}
    		
        	else if(p1total == p2total)
                	{
                		whoWins.setText("There Is A Tie!");
                	}
    		
    		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
        			new PieChart.Data(player1Name.getText().trim(), p1total), 
        	        new PieChart.Data(player2Name.getText().trim(), p2total));
        	pieChart.setData(pieChartData);
    	}
    	
    	if(playerCount == 3)
    	{
    		//player 1 won
    		if(p1total < p2total && p1total < p3total)
        	{
        		whoWins.setText(player1Name.getText().trim() + " wins!");
        	}
        	//player 2 won
        	else if(p2total < p1total && p2total < p3total)
        	{
        		whoWins.setText(player2Name.getText().trim() + " wins!");
        	}
        	//player 3 won
        	else if(p3total < p1total && p3total < p2total)
        	{
        		whoWins.setText(player3Name.getText().trim() + " wins!");
        	}
    		
        	else if(p1total == p2total || p1total == p3total || p2total == p3total)
                	{
                		whoWins.setText("There Is A Tie!");
                	}
    		
    		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
        			new PieChart.Data(player1Name.getText().trim(), p1total), 
        	        new PieChart.Data(player2Name.getText().trim(), p2total), 
        	        new PieChart.Data(player3Name.getText().trim(), p3total));
        	pieChart.setData(pieChartData);
    	}
    	
    	
    	if(playerCount == 4)
    	{
    		//displaying who won the game
        	//player 1 won
        	if(p1total < p2total && p1total < p3total && p1total < p4total)
        	{
        		whoWins.setText(player1Name.getText().trim() + " wins!");
        	}
        	//player 2 won
        	else if(p2total < p1total && p2total < p3total && p2total < p4total)
        	{
        		whoWins.setText(player2Name.getText().trim() + " wins!");
        	}
        	//player 3 won
        	else if(p3total < p1total && p3total < p2total && p3total < p4total)
        	{
        		whoWins.setText(player3Name.getText().trim() + " wins!");
        	}
        	//player 4 won
        	else if(p4total < p1total && p4total < p2total && p4total < p3total)
        	{
        		whoWins.setText(player4Name.getText().trim() + " wins!");
        	}
        	else if(p1total == p2total || p1total == p3total || 
        	p1total == p4total || p2total == p3total || p2total == p4total || p3total == p4total)
        	{
        		whoWins.setText("There Is A Tie!");
        	}
        	
        	
        	
        	ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
        			new PieChart.Data(player1Name.getText().trim(), p1total), 
        	        new PieChart.Data(player2Name.getText().trim(), p2total), 
        	        new PieChart.Data(player3Name.getText().trim(), p3total), 
        	        new PieChart.Data(player4Name.getText().trim(), p4total));
        	
        	pieChart.setData(pieChartData);
    	}
    	
    	
    }
    
    
    
    
    
    
    
    
    
    void zeroCheck()
    {
    	//
    	//CHECK FOR PLAYER 1
    	//
    	if(p1h1.getText().trim().equals(""))
    	{
    		p1h1.setText("0");
    	}
    	if(p1h2.getText().trim().equals(""))
    	{
    		p1h2.setText("0");
    	}
    	if(p1h3.getText().trim().equals(""))
    	{
    		p1h3.setText("0");
    	}
    	if(p1h4.getText().trim().equals(""))
    	{
    		p1h4.setText("0");
    	}
    	if(p1h5.getText().trim().equals(""))
    	{
    		p1h5.setText("0");
    	}
    	if(p1h6.getText().trim().equals(""))
    	{
    		p1h6.setText("0");
    	}
    	if(p1h7.getText().trim().equals(""))
    	{
    		p1h7.setText("0");
    	}
    	if(p1h8.getText().trim().equals(""))
    	{
    		p1h8.setText("0");
    	}
    	if(p1h9.getText().trim().equals(""))
    	{
    		p1h9.setText("0");
    	}
    	
    	//
    	//CHECK FOR PLAYER 2
    	//
    	if(p2h1.getText().trim().equals(""))
    	{
    		p2h1.setText("0");
    	}
    	if(p2h2.getText().trim().equals(""))
    	{
    		p2h2.setText("0");
    	}
    	if(p2h3.getText().trim().equals(""))
    	{
    		p2h3.setText("0");
    	}
    	if(p2h4.getText().trim().equals(""))
    	{
    		p2h4.setText("0");
    	}
    	if(p2h5.getText().trim().equals(""))
    	{
    		p2h5.setText("0");
    	}
    	if(p2h6.getText().trim().equals(""))
    	{
    		p2h6.setText("0");
    	}
    	if(p2h7.getText().trim().equals(""))
    	{
    		p2h7.setText("0");
    	}
    	if(p2h8.getText().trim().equals(""))
    	{
    		p2h8.setText("0");
    	}
    	if(p2h9.getText().trim().equals(""))
    	{
    		p2h9.setText("0");
    	}
    	
    	//
    	//CHECK FOR PLAYER 3
    	//
    	if(p3h1.getText().trim().equals(""))
    	{
    		p3h1.setText("0");
    	}
    	if(p3h2.getText().trim().equals(""))
    	{
    		p3h2.setText("0");
    	}
    	if(p3h3.getText().trim().equals(""))
    	{
    		p3h3.setText("0");
    	}
    	if(p3h4.getText().trim().equals(""))
    	{
    		p3h4.setText("0");
    	}
    	if(p3h5.getText().trim().equals(""))
    	{
    		p3h5.setText("0");
    	}
    	if(p3h6.getText().trim().equals(""))
    	{
    		p3h6.setText("0");
    	}
    	if(p3h7.getText().trim().equals(""))
    	{
    		p3h7.setText("0");
    	}
    	if(p3h8.getText().trim().equals(""))
    	{
    		p3h8.setText("0");
    	}
    	if(p3h9.getText().trim().equals(""))
    	{
    		p3h9.setText("0");
    	}
    	
    	//
    	//CHECK FOR PLAYER 4
    	//
    	if(p4h1.getText().trim().equals(""))
    	{
    		p4h1.setText("0");
    	}
    	if(p4h2.getText().trim().equals(""))
    	{
    		p4h2.setText("0");
    	}
    	if(p4h3.getText().trim().equals(""))
    	{
    		p4h3.setText("0");
    	}
    	if(p4h4.getText().trim().equals(""))
    	{
    		p4h4.setText("0");
    	}
    	if(p4h5.getText().trim().equals(""))
    	{
    		p4h5.setText("0");
    	}
    	if(p4h6.getText().trim().equals(""))
    	{
    		p4h6.setText("0");
    	}
    	if(p4h7.getText().trim().equals(""))
    	{
    		p4h7.setText("0");
    	}
    	if(p4h8.getText().trim().equals(""))
    	{
    		p4h8.setText("0");
    	}
    	if(p4h9.getText().trim().equals(""))
    	{
    		p4h9.setText("0");
    	}
    	
    }
    
    
    
    //gets the info player 1 and adds to array list, calculates total, and displays total
    void player1Total()
    {
    	ArrayList<Integer> player1Info = new ArrayList<Integer>();
    	
    	player1Info.add(Integer.parseInt(p1h1.getText().trim()));
    	player1Info.add(Integer.parseInt(p1h2.getText().trim()));
    	player1Info.add(Integer.parseInt(p1h3.getText().trim()));
    	player1Info.add(Integer.parseInt(p1h4.getText().trim()));
    	player1Info.add(Integer.parseInt(p1h5.getText().trim()));
    	player1Info.add(Integer.parseInt(p1h6.getText().trim()));
    	player1Info.add(Integer.parseInt(p1h7.getText().trim()));
    	player1Info.add(Integer.parseInt(p1h8.getText().trim()));
    	player1Info.add(Integer.parseInt(p1h9.getText().trim()));
    	
    	int p1tot = 0;
    	for(int i = 0; i < 9; i++)
    	{
    		p1tot += player1Info.get(i);
    	}
    	
    	String p1T = String.valueOf(p1tot);
    	
    	p1Total.setText(p1T);
    }
    
  //gets the info player 2 and adds to array list, calculates total, and displays total
    void player2Total()
    {
    	ArrayList<Integer> player2Info = new ArrayList<Integer>();
    	
    	player2Info.add(Integer.parseInt(p2h1.getText().trim()));
    	player2Info.add(Integer.parseInt(p2h2.getText().trim()));
    	player2Info.add(Integer.parseInt(p2h3.getText().trim()));
    	player2Info.add(Integer.parseInt(p2h4.getText().trim()));
    	player2Info.add(Integer.parseInt(p2h5.getText().trim()));
    	player2Info.add(Integer.parseInt(p2h6.getText().trim()));
    	player2Info.add(Integer.parseInt(p2h7.getText().trim()));
    	player2Info.add(Integer.parseInt(p2h8.getText().trim()));
    	player2Info.add(Integer.parseInt(p2h9.getText().trim()));
    	
    	int p2tot = 0;
    	for(int i = 0; i < 9; i++)
    	{
    		p2tot += player2Info.get(i);
    	}
    	
    	String p2T = String.valueOf(p2tot);
    	
    	p2Total.setText(p2T);
    }
    
  //gets the info player 3 and adds to array list, calculates total, and displays total
    void player3Total()
    {
    	ArrayList<Integer> player3Info = new ArrayList<Integer>();
    	
    	player3Info.add(Integer.parseInt(p3h1.getText().trim()));
    	player3Info.add(Integer.parseInt(p3h2.getText().trim()));
    	player3Info.add(Integer.parseInt(p3h3.getText().trim()));
    	player3Info.add(Integer.parseInt(p3h4.getText().trim()));
    	player3Info.add(Integer.parseInt(p3h5.getText().trim()));
    	player3Info.add(Integer.parseInt(p3h6.getText().trim()));
    	player3Info.add(Integer.parseInt(p3h7.getText().trim()));
    	player3Info.add(Integer.parseInt(p3h8.getText().trim()));
    	player3Info.add(Integer.parseInt(p3h9.getText().trim()));
    	
    	int p3tot = 0;
    	for(int i = 0; i < 9; i++)
    	{
    		p3tot += player3Info.get(i);
    	}
    	
    	String p3T = String.valueOf(p3tot);
    	
    	p3Total.setText(p3T);
    }
    
  //gets the info player 4 and adds to array list, calculates total, and displays total
    void player4Total()
    {
    	ArrayList<Integer> player4Info = new ArrayList<Integer>();
    	
    	player4Info.add(Integer.parseInt(p4h1.getText().trim()));
    	player4Info.add(Integer.parseInt(p4h2.getText().trim()));
    	player4Info.add(Integer.parseInt(p4h3.getText().trim()));
    	player4Info.add(Integer.parseInt(p4h4.getText().trim()));
    	player4Info.add(Integer.parseInt(p4h5.getText().trim()));
    	player4Info.add(Integer.parseInt(p4h6.getText().trim()));
    	player4Info.add(Integer.parseInt(p4h7.getText().trim()));
    	player4Info.add(Integer.parseInt(p4h8.getText().trim()));
    	player4Info.add(Integer.parseInt(p4h9.getText().trim()));
    	
    	int p4tot = 0;
    	for(int i = 0; i < 9; i++)
    	{
    		p4tot += player4Info.get(i);
    	}
    	
    	String p4T = String.valueOf(p4tot);
    	
    	p4Total.setText(p4T);
    }
    
    int noPlayer()
    {
    	if(player2Name.getText().trim().equals("Player 2"))
    	{
    		//there is no one playing as player 2, only 1 player
    		return 1;
    	}
    	
    	if(player3Name.getText().trim().equals("Player 3"))
    	{
    		//there is no one playing as player 3, only 2 players
    		return 2;
    	}
    	
    	if(player4Name.getText().trim().equals("Player 4"))
    	{
    		//there is no one playing as player 4, only 3 players
    		return 3;
    	}
    	
    	return 4;
    }
    
    @FXML
    void resetButton(ActionEvent event) {
    	
    	whoWins.setText("");
    	
    	
    	pieChart.setOpacity(0.0);
    	
    	p1h1.setText("");
    	p1h2.setText("");
    	p1h3.setText("");
    	p1h4.setText("");
    	p1h5.setText("");
    	p1h6.setText("");
    	p1h7.setText("");
    	p1h8.setText("");
    	p1h9.setText("");
    	p1Total.setText("");
    	
    	p2h1.setText("");
    	p2h2.setText("");
    	p2h3.setText("");
    	p2h4.setText("");
    	p2h5.setText("");
    	p2h6.setText("");
    	p2h7.setText("");
    	p2h8.setText("");
    	p2h9.setText("");
    	p2Total.setText("");
    	
    	p3h1.setText("");
    	p3h2.setText("");
    	p3h3.setText("");
    	p3h4.setText("");
    	p3h5.setText("");
    	p3h6.setText("");
    	p3h7.setText("");
    	p3h8.setText("");
    	p3h9.setText("");
    	p3Total.setText("");
    	
    	p4h1.setText("");
    	p4h2.setText("");
    	p4h3.setText("");
    	p4h4.setText("");
    	p4h5.setText("");
    	p4h6.setText("");
    	p4h7.setText("");
    	p4h8.setText("");
    	p4h9.setText("");
    	p4Total.setText("");
    }

}
