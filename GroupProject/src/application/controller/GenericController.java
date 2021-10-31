package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

public class GenericController {
	
    @FXML
    private TextArea teamOnePoints;

    @FXML
    private TextArea teamTwoPoints;
    
    @FXML
    private ProgressBar pointComp;
    
    public int pointVal = 2;

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
}
