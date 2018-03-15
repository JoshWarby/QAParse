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
	private Button submitButton = new Button("   Parse   ");
	private Label inlbl = new Label("Paste Text");
	private Label outlbl = new Label("Parsed Text");
	private HBox box = new HBox();
	private Button clearButton = new Button("Clear All");
	private Button csvButton = new Button("Export to CSV");
	
	public RootPane (){
		//styling
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(10);
		this.setHgap(10);
		this.setAlignment(Pos.CENTER);
		this.setStyle("-fx-background-color:#BDBDBD; -fx-opacity:1;");
		
		inlbl.setStyle("-fx-font-weight: bold");
		outlbl.setStyle("-fx-font-weight: bold");
		double height = 900; //making a variable called height with a value 400
		double width = 700;  //making a variable called height with a value 300

		//You can use these methods
		inTA.prefWidthProperty().bind(this.widthProperty());
		outTA.prefWidthProperty().bind(this.widthProperty());
		inTA.prefHeightProperty().bind(this.heightProperty());
		outTA.prefHeightProperty().bind(this.heightProperty());
		
		inTA.setMaxHeight(height);
		outTA.setMaxHeight(height);
		inTA.setMaxWidth(width);
		outTA.setMaxWidth(width);
		
		this.add(inlbl, 0, 0);
		this.add(outlbl, 1, 0);
		this.add(inTA, 0, 1);
		this.add(outTA, 1, 1);
		box.getChildren().addAll(submitButton,csvButton,clearButton);
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
	
	public void addClearHandler(EventHandler<ActionEvent> handler) {
		clearButton.setOnAction(handler);
	}
	public void addSubmitHandler(EventHandler<ActionEvent> handler) {
		submitButton.setOnAction(handler);
	}
	public void addCSVHandler(EventHandler<ActionEvent> handler) {
		csvButton.setOnAction(handler);
	}
}
