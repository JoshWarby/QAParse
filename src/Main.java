import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;

public class Main {


	
	public static void main(String[] args) throws IOException {
		String everything;
		BufferedReader br = new BufferedReader(new FileReader("./filein.txt"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		    	if (isFullnameCaps(line)){
		    		if (line.equals("Course Details")){
		    			sb.append("-------NEW COURSE-------");
				        sb.append(System.lineSeparator());	
		    		}
		    		else if (line.equals("Status Printed")){
		    		}
		    		
		    		else{
		    		sb.append(line);
			        sb.append(System.lineSeparator());	
		    		}
		    	}
		    	line = br.readLine();
		    }
		    everything = sb.toString();
		} finally {
		    br.close();
		}
		
		
		try(  PrintWriter out = new PrintWriter( "./fileout.txt" )  ){
		    out.println( everything );
		}
		System.out.print("Complete, press enter to close.");
		
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
	}
	
	
	public static boolean isFullnameCaps(String str) {
	    boolean isValid = false;
	    
	    if (str.contains("Hide")||str.contains("Created")||str.contains("Submitted")||str.contains("Assessments")||str.contains("Certificate")||str.contains("Catastrophic")||str.contains("First Aid")||str.contains("MCQ")||str.contains("End Date")||str.contains("  ")){
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
	
	
	/*
	public static boolean isFullnameCaps(String str) {
	    boolean isValid = false;
	    String expression = "(([A-z']+) (- [A-z']* )?([A-z']*)?( [A-z']*)?)";
	    CharSequence inputStr = str;
	    Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(inputStr);
	    if (matcher.matches()) {
	        isValid = true;
	    }
	    if (str.contains("Start Date")&& !str.contains("  ")){
	    	isValid = true;
	    }
	    if (str.contains(" Yes")||str.contains(" No")){
	    	isValid = false;
	    }
	    return isValid;
	}
	*/
}
