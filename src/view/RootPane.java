package view;

import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;

public class RootPane extends GridPane{

	private TextArea inTA = new TextArea();
	private TextArea outTA = new TextArea();
	private Button submitButton = new Button("Parse");
	private Label inlbl = new Label("Paste Text");
	private Label outlbl = new Label("Parsed Text");
	private HBox box = new HBox();
	private Label clickedlbl = new Label("");
	
	public RootPane (){
		//styling
		this.setPadding(new Insets(80, 80, 80, 80));
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		double height = 600; //making a variable called height with a value 400
		double width = 500;  //making a variable called height with a value 300

		//You can use these methods
		inTA.setPrefHeight(height);  //sets height of the TextArea to 400 pixels 
		inTA.setPrefWidth(width);    //sets width of the TextArea to 300 pixels
		outTA.setPrefHeight(height);  //sets height of the TextArea to 400 pixels 
		outTA.setPrefWidth(width);    //sets width of the TextArea to 300 pixels
		
		this.add(inlbl, 0, 0);
		this.add(outlbl, 1, 0);
		this.add(inTA, 0, 1);
		this.add(outTA, 1, 1);
		box.getChildren().add(submitButton);
		this.add(box, 0, 2);
}
	
	public void clearIn(){
		inTA.clear();
	}
	public void clearOut(){
		outTA.clear();
	}
	public String getInString(){
		return inTA.getText();
	}
	
	public void setOutString(String out){
		outTA.insertText(0,out);
	}
	
	
	public void addSubmitHandler(EventHandler<ActionEvent> handler) {
		submitButton.setOnAction(handler);
	}
}
