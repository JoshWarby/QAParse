package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.RootPane;
public class Controller {

	String inStr;
	String outStr = "";
	RootPane view;
	int counter = 1;
	public Controller(RootPane view) {
		this.view = view;
		this.attachEventHandlers();
	}
	private void attachEventHandlers() {
		view.addSubmitHandler(new AddSubmitHandler()); //attaches add button handler
	}
	
	private class AddSubmitHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			view.clearOut();
			inStr = view.getInString();

			Scanner scanner = new Scanner(inStr);
			outStr+="***************PASTE "+Integer.toString(counter)+"***************\n";
			while (scanner.hasNextLine()) {
			  String line = scanner.nextLine();
			  if (isFullnameCaps(line)){
				  if (line.equals("Course Details")){
					  outStr+=("-------NEW COURSE-------")+"\n";
		    		}
		    		else if (line.contains("Learners") && !line.contains("No.")){
		    		}
		    		
		    		else{
		    			outStr+=line+"\n";
		    		}
			  }
			}
			scanner.close();
			view.setOutString(outStr);
			view.clearIn();
			counter++;
			}
		}
		
		
	public boolean isFullnameCaps(String str) {
	    boolean isValid = false;
	    
	    if (str.contains("Hide")||str.contains("Created")||str.contains("Submitted")||str.contains("Assessments")||str.contains("Certificate")||str.contains("Catastrophic")||str.contains("First Aid")||str.contains("MCQ")||str.contains("End Date")||str.contains("  ")||str.contains("Status Printed")||str.contains("Reference")){
	    	isValid = false;
	    }
	    
	    else if (str.contains(" Yes")||str.contains(" No")||str.contains("N/A")){
	    	isValid = false;
	    }
	    
	    else if (str.equals(" ")){
	    	isValid = false;
	    }
	    
	    else if (str.contains("Start Date")&& !str.contains("  ")){
	    	isValid = true;
	    }
	    else{
	    	isValid = true;
	    }
	    
	    return isValid;
	}

}
