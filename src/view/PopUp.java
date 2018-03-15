package view;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * This class creates a pop up window informing the user of a given message.
 * @author Josh
 *
 */
public class PopUp {
   
/**
 * Displays the pop-up.
 * @param lbl the text the label on the pop-up should display.
 */
public static void display(String lbl)
{
	Stage popupwindow=new Stage();
	popupwindow.initStyle(StageStyle.UNDECORATED);
	      
	popupwindow.initModality(Modality.APPLICATION_MODAL);
	popupwindow.setTitle("Application Message");
	      
	      
	Label label1= new Label(lbl);
	      
	     
	Button button1= new Button("Close");
	     
	     
	button1.setOnAction(e -> popupwindow.close());
	     
	     
	
	VBox layout= new VBox(10);
	     
	      
	layout.getChildren().addAll(label1, button1);
	layout.setStyle("-fx-padding: 10;" + 
            "-fx-border-style: solid inside;" + 
            "-fx-border-width: 2;" +
            "-fx-border-insets: 5;" + 
            "-fx-border-radius: 5;" + 
            "-fx-border-color: red;");
	      
	layout.setAlignment(Pos.CENTER);
	      
	Scene scene1= new Scene(layout, 200, 75);
	      
	popupwindow.setScene(scene1);
	      
	popupwindow.showAndWait();
       
}

}
