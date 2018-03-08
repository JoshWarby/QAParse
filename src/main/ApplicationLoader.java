package main;
import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.RootPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is the runnable class for the admin program.
 * @author Josh
 *
 */
public class ApplicationLoader extends Application{

	RootPane view = new RootPane();
	Controller ac;
	
	@Override
	public void init() {
		//create model and view and pass their references to the controller
		view = new RootPane();
		ac = new Controller(view);
	}
	
	/**
	 * Starts the GUI
	 * @param Stage The stage of which every page will be shown upon.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		stage.setMinWidth(900); //sets min width and height for the stage window
		stage.setMinHeight(800);
		stage.setTitle("Admin Program");
		stage.setScene(new Scene(view));
		stage.show();
	}

	public static void main(String[] args) {
		//populate list
		launch(args);
	}
}
