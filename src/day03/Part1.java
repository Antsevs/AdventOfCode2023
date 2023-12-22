package day03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* document filled with numbers and symbols is an engine schematic
 * any number adjacent to a symbol, even diagonally, is a part number
 * find the sum of all part numbers
 * periods do not count as symbols
 */

public class Part1 {
	
	public static void main(String[] args) throws FileNotFoundException{
		partNumFinder();
	}
	
	//grab data from puzzle input
	
	public static List<String> getData() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sevar\\eclipse-workspace\\adventCode2023\\puzzleInputFiles\\day03\\puzzleInput03_1"));
		List<String> list = new ArrayList<String>();
		String data;
		try {
			while((data = br.readLine()) != null) {
				list.add(data);
			} 
		} catch(IOException e) {
				e.printStackTrace();
			}
		return list;
	}
	
	public static void partNumFinder() throws FileNotFoundException {
		String currentStr;
	    String belowStr;
	    String aboveStr;
	    List<String> data = Part1.getData();
	    List<Integer> partNums = new ArrayList<Integer>();

	    // iterate through each line
	    for (int n = 0; n < data.size(); n++) {
	    	currentStr = data.get(n);
	       // System.out.println(currentStr);
	        // if there is a line above, set to aboveStr, if there is a line below, set to belowStr
	        belowStr = (n + 1 < data.size()) ? data.get(n + 1) : "";
	       // System.out.println(belowStr + "below");
	        aboveStr = (n - 1 >= 0) ? data.get(n - 1) : "";
	       // System.out.println(aboveStr + "above");

	        int numInt = 0;
	        String numStr = "";
	        int digitCount = 0;
	        int index = 0;

	        // iterate through each character
	        for (int i = 0; i < currentStr.length(); i++) {
	           numInt = 0;
	        	// if character is a digit, add to numStr
	            if (Character.isDigit(currentStr.charAt(i))) {
	                numStr += currentStr.charAt(i);
	                System.out.println(numStr);
	                digitCount++;
	                index = i - (digitCount + 1);
	            } else if (!numStr.isEmpty()) {
	            	//check if sameline connection
	            	if(index >= 0 && (charIsSymbol(currentStr.charAt(index)) || charIsSymbol(currentStr.charAt(i)))) {
	            		numInt = Integer.parseInt(numStr);
	            		partNums.add(numInt);
	            		System.out.println(partNums);
	            		numStr = "";
	            	}
	            }
	        }
	    }
	}
	
	public static boolean charIsSymbol(char c) {
		boolean decision;
		int ascii = c;
		if((ascii >= 33 && ascii <= 45) || (ascii >= 47 && ascii <=64)) {
			decision = true;
		} else {
			decision = false;
		}
		
		return decision;
	}
	
}
	
