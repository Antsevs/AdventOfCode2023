package day01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* week 1 part 2
 *  Some of the lines include numbers written in english
 *  include these numbers in the decryption
 *  assume the numbers phonetically spelled are zero to ten
 *  let's convert the entire string to numbers, then do our thing
 *  i.e. two1nine = 29; 4nineeightseven2 = 42; 7pqrstsixteen = 76;
 */
public class Part2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sevar\\eclipse-workspace\\adventCode2023\\puzzleInputFiles\\week1_2_input"));
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
					//f**k it I'm brute forcing it
				} else if(n + 2 < currentStr.length() && currentStr.substring(n, n+3).equals("one")) {
					if(num1 != 0) {
						num2 = '1';
					} else {
						num1 = '1';
					}
				} else if( n + 2 < currentStr.length() && currentStr.substring(n, n+3).equals("two")) {
					if(num1 != 0) {
						num2 = '2';
					} else {
						num1 = '2';
					}			
				} else if( n + 4 < currentStr.length() && currentStr.substring(n, n+5).equals("three")) {
					if(num1 != 0) {
						num2 = '3';
					} else {
						num1 = '3';
					}
				} else if( n + 3 < currentStr.length() && currentStr.substring(n, n+4).equals("four")) {
					if(num1 != 0) {
						num2 = '4';
					} else {
						num1 = '4';
					}
				} else if( n + 3 < currentStr.length() && currentStr.substring(n, n+4).equals("five")) {
					if(num1 != 0) {
						num2 = '5';
					} else {
						num1 = '5';
					}
				} else if( n + 2 < currentStr.length() && currentStr.substring(n, n+3).equals("six")) {
					if(num1 != 0) {
						num2 = '6';
					} else {
						num1 = '6';
					}
				} else if( n + 4 < currentStr.length() && currentStr.substring(n, n+5).equals("seven")) {
					if(num1 != 0) {
						num2 = '7';
					} else {
						num1 = '7';
					}
				} else if( n + 4 < currentStr.length() && currentStr.substring(n, n+5).equals("eight")) {
					if(num1 != 0) {
						num2 = '8';
					} else {
						num1 = '8';
					}
				} else if( n + 3 < currentStr.length() && currentStr.substring(n, n+4).equals("nine")) {
					if(num1 != 0) {
						num2 = '9';
					} else {
						num1 = '9';
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
			//System.out.println(num1 + "and" + num2);
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
