package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GolfController {

    @FXML
    private AnchorPane golfPane;
    
    @FXML
    private Label whoWins;
    
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
    	
    	int p1total = Integer.parseInt(p1Total.getText().trim());
    	int p2total = Integer.parseInt(p2Total.getText().trim());
    	
    	if(player1Name.getText().trim().equals(""))
    	{
    		player1Name.setText("Player 1");
    	}
    	
    	if(player2Name.getText().trim().equals(""))
    	{
    		player2Name.setText("Player 2");
    	}
    	
    	if(p2total < p1total)
    	{
    		whoWins.setText(player2Name.getText().trim() + " wins!");
    	}
    	
    	if(p1total < p2total)
    	{
    		whoWins.setText(player1Name.getText().trim() + " wins!");
    	}
    	
    	
    	
    }
    
    
    
    
    
    
    
    
    
    void zeroCheck()
    {
    	//CHECK FOR PLAYER 1
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
    	
    }
    
    
    
    
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

}
