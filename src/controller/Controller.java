package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import model.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.*;
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
		view.addClearHandler(new AddClearHandler());
		view.addCSVHandler(new AddCSVHandler());
	}
	
	private class AddClearHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			outStr = "";
			view.clearOut();
			view.clearIn();
			counter = 1;
		}
	}
	
	private class AddCSVHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			try {
				CSVWrite(outStr);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
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
					  //
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
	    
	    if (str.contains("N/A")||str.contains("Created")||str.contains("Submitted")||str.contains("Assessments")||str.contains("Certificate")||str.contains("Catastrophic")||str.contains("First Aid")||str.contains("MCQ")||str.contains("End Date")||str.contains("  ")||str.contains("Status Printed")||str.contains("Reference")){
	    	isValid = false;
	    }
	    else if (str.contains(" Yes")||str.contains(" No")||str.contains("Hide")){
	    	String pattern = "(Yes|No|Hide)(.)+";
	        // Create a Pattern object
	        Pattern r = Pattern.compile(pattern);
	        // Now create matcher object.
	        Matcher m = r.matcher(str);
	        if (m.find( )) {
	        	isValid = true;
	        }else {
	        	isValid = false;
	        }
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
	
	 public void CSVWrite(String inStr) throws FileNotFoundException{
	        PrintWriter pw = new PrintWriter(new File("./QA_Names.csv"));
	        StringBuilder sb = new StringBuilder();

	        Scanner scanner = new Scanner(inStr);
			while (scanner.hasNextLine()) {
			  String line = scanner.nextLine();
			  sb.append(line+"\n");
			  }
			scanner.close();

	        pw.write(sb.toString());
	        pw.close();
	        PopUp.display("CSV File Refreshed");
	    }

}
