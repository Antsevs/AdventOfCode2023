package day01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* week 1 part 1
 *  take a string of numbers and letters, combine the first digit in string and last digit in string
 *  to make an integer 
 *  i.e. 1abc2 = 12 ; pqr3stu8vwx = 38 ; treb7uchet = 77
 *  find sum of all combined integers in document
 */
public class Part1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sevar\\eclipse-workspace\\adventCode2023\\puzzleInputFiles\\week1_1_input"));
		String str;
		char num2 = 0;
		char num1 = 0;
		char numChar;
		String combinedChar;
		int combinedNum = 0;
		int result = 0;
		List<String> strList = new ArrayList<String>();
		List<Integer> numList = new ArrayList<Integer>();
		try {
			while((str = br.readLine()) != null) {
				strList.add(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String currentStr;
		//assume each line has a number and that each combined number is two digits
		//iterate through each line
		for(int i = 0; i < strList.size(); i++) {
			currentStr = strList.get(i);
			//checking if grabbing correct strings
			//System.out.println(strList.get(i));
			//iterate through each character in a line
			for(int n = 0; n < currentStr.length(); n++) {
				//check if current character is an integer
				if(Character.isDigit(currentStr.charAt(n))) {
					numChar = currentStr.charAt(n);
					//if the first number has already been assigned assign it to the second number
					if(num1 != 0) {
						num2 = numChar;
					} else {
						num1 = numChar;
					}
				}
			}
			//if there is only one integer in the string, duplicate
			if(num2 == 0) {
				combinedChar = "" + num1 + num1;
			} else {
				combinedChar = "" + num1 + num2;
			}
			//convert combined characters into an integer to add to integer arraylist
			combinedNum = Integer.parseInt(combinedChar);
			numList.add(combinedNum);
			//reset values
			num1 = 0;
			num2 = 0;
		}
		//checking if numlist looks right
		//System.out.println(numList);
		for(int j = 0; j < numList.size(); j++) {
			result += numList.get(j);
		}
		System.out.println(result);
	}
}
