package day02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* week 2 part 1
 *  multiple games, bag with various cubes reside
 *  blue, red, and green of random amounts
 *  in a single game, a few rounds of drawing cubes are played
 *  any number of each can be pulled and shown
 *  establish which of the presented games are possible if there are:
 *  12 red cubes, 13 green cubes, and 14 blue cubes
 */
public class Part1 {

	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sevar\\eclipse-workspace\\adventCode2023\\puzzleInputFiles\\day02\\puzzleInput02_1"));
		int green;
		int blue;
		int red;
		String currentNum;
		String str;
		String currentStr;
		char currentID;
		char currentID2;
		char currentID3;
		int digitCount;
		int colonCheck;
		int result = 0;
		List<String> strList = new ArrayList<String>();
		List<String> gameIDs = new ArrayList<String>();
		try {
			while((str = br.readLine()) != null) {
				strList.add(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//iterate through each game
		for(int n = 0; n < strList.size(); n++) {
			//reset counter variables
			currentStr = strList.get(n);
			currentID = 0;
			currentID2 = 0;
			currentID3 = 0;
			digitCount = 0;
			colonCheck = 0;
			green = 0;
			red = 0;
			blue = 0;
			currentNum = null;
			//iterate through each character of a game
			for(int i = 0; i < currentStr.length(); i++) {
				//find game ID number
				if(Character.isDigit(currentStr.charAt(i)) && currentStr.charAt(i) != ':' && colonCheck != -1) {
					if(currentID != 0 && currentID2 == 0) {
						currentID2 = currentStr.charAt(i);
						digitCount = 2;
					} else if(currentID2 != 0 && currentID3 == 0) {
						currentID3 = currentStr.charAt(i);
						digitCount = 3;
					} else {
						currentID = currentStr.charAt(i);
						digitCount = 1;
					}
				//if colon is struck enter search for cube amounts instead of gameID
				} else if(currentStr.charAt(i) == ':') {
					colonCheck = -1;
				}
				//check which cube the number pertains to and add it to its variable
				if(Character.isDigit(currentStr.charAt(i)) && colonCheck == -1) {
					//check for two digit numbers by looking for part of color word
					if(currentStr.charAt(i+3) == 'g' && currentStr.charAt(i+4) == 'r' && currentStr.charAt(i+5) == 'e') {
						currentNum = ("" + currentStr.charAt(i) + currentStr.charAt(i+1)).trim();
						//if it is not the largest of this color, do not record
						if(green < Integer.parseInt(currentNum)) {
							green = Integer.parseInt(currentNum);
						}
					} else if(currentStr.charAt(i+3) == 'r' && currentStr.charAt(i+4) == 'e' && currentStr.charAt(i+5) == 'd') {
						currentNum = ("" + currentStr.charAt(i) + currentStr.charAt(i+1)).trim();
						if(red < Integer.parseInt(currentNum)) {
							red = Integer.parseInt(currentNum);
						}
					} else if(currentStr.charAt(i+3) == 'b' && currentStr.charAt(i+4) == 'l' && currentStr.charAt(i+5) == 'u') {
						currentNum = ("" + currentStr.charAt(i) + currentStr.charAt(i+1)).trim();
						if(blue < Integer.parseInt(currentNum)) {
							blue = Integer.parseInt(currentNum);
						}
					//check for single digit integers by looking for part of color word and ensuring it isnt a two digit by checking the previous character for a digit
					} else if(currentStr.charAt(i+2) == 'g' && currentStr.charAt(i+3) == 'r' && currentStr.charAt(i+4) == 'e'&& !Character.isDigit(currentStr.charAt(i-1))){
						currentNum = ("" + currentStr.charAt(i)).trim();
						if(green < Integer.parseInt(currentNum)) {
							green = Integer.parseInt(currentNum);
						}
					} else if(currentStr.charAt(i+2) == 'r' && currentStr.charAt(i+3) == 'e' && currentStr.charAt(i+4) == 'd'&& !Character.isDigit(currentStr.charAt(i-1))){
						currentNum = ("" + currentStr.charAt(i)).trim();
						if(red < Integer.parseInt(currentNum)) {
							red = Integer.parseInt(currentNum);
						}
					} else if(currentStr.charAt(i+2) == 'b' && currentStr.charAt(i+3) == 'l' && currentStr.charAt(i+4) == 'u'&& !Character.isDigit(currentStr.charAt(i-1))){
						currentNum = ("" + currentStr.charAt(i)).trim();
						if(blue < Integer.parseInt(currentNum)) {
							blue = Integer.parseInt(currentNum);
						}
					}
				}
			}
			//store each possible gameID number by applying color constraints
			if(red <= 12 && green <= 13 && blue <= 14) {
				if(digitCount == 1) {
					gameIDs.add(currentID + "");
				} else if(digitCount == 2) {
					gameIDs.add(currentID + "" + currentID2);
				} else if(digitCount == 3) {
					gameIDs.add(currentID + "" + currentID2 + "" + currentID3);
				}
			}
		}
		System.out.println(gameIDs);
		//tally the game IDs
		for(int count = 0; count < gameIDs.size(); count++) {
			result += Integer.parseInt(gameIDs.get(count));
		}
		System.out.println("The possible sum of the IDs of the possible games is: " + result);
	}
}
