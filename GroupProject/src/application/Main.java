//worked on by John Jones and Matthew Wilson
package application;
	
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import application.model.GraphEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


//test
public class Main extends Application {
	
	
	public static long gameStartTime;
	public static ArrayList<GraphEvent> GraphEvents = new ArrayList<GraphEvent>();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = new File("src/application/view/Main.fxml").toURI().toURL();
			AnchorPane root = (AnchorPane)FXMLLoader.load(url);
			Scene scene = new Scene(root,800,800);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
