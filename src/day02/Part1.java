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
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sevar\\eclipse-workspace\\adventCode2023\\puzzleInputFiles\\week2_1_input"));
		int green;
		int blue;
		int red;
		int game;
		String currentNum;
		String str;
		String currentStr;
		char currentID;
		char currentID2;
		char currentID3;
		int digitCount;
		int colonCheck;
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
				if(Character.isDigit(currentStr.charAt(i))) {
					//check for two digit numbers
					if(currentStr.charAt(i+3) == 'g') {
						currentNum = ("" + currentStr.charAt(i) + currentStr.charAt(i+1)).trim();
						green += Integer.parseInt(currentNum);
						System.out.println("green: " + green);
					} else if(currentStr.charAt(i+3) == 'r') {
						currentNum = ("" + currentStr.charAt(i) + currentStr.charAt(i+1)).trim();
						red += Integer.parseInt(currentNum);
						System.out.println("red: " + red);
					} else if(currentStr.charAt(i+3) == 'b') {
						currentNum = ("" + currentStr.charAt(i) + currentStr.charAt(i+1)).trim();
						blue += Integer.parseInt(currentNum);
						System.out.println("blue: " + blue);
					//check for single digit integers
					} else if(currentStr.charAt(i+2) == 'g' && !Character.isDigit(currentStr.charAt(i-1))){
						currentNum = ("" + currentStr.charAt(i)).trim();
						green += Integer.parseInt(currentNum);
						System.out.println("green: " + green);
					} else if(currentStr.charAt(i+2) == 'r' && !Character.isDigit(currentStr.charAt(i-1))){
						currentNum = ("" + currentStr.charAt(i)).trim();
						red += Integer.parseInt(currentNum);
						System.out.println("red: " + red);
					} else if(currentStr.charAt(i+2) == 'b' && !Character.isDigit(currentStr.charAt(i-1))){
						currentNum = ("" + currentStr.charAt(i)).trim();
						blue += Integer.parseInt(currentNum);
						System.out.println("blue: " + blue);
					}
				}

				
			}
			//store each game ID number
			if(red <= 12 && green <= 13 && blue <= 14) {
				if(digitCount == 1) {
					gameIDs.add(currentID + "");
				} else if(digitCount == 2) {
					gameIDs.add(currentID + "" + currentID2);
				} else if(digitCount == 3) {
					gameIDs.add(currentID + "" + currentID2 + "" + currentID3);
				}
			}
			//System.out.println(gameIDs);
			for(int i = 0; i <strList.get(n).length(); i++) {
				
			}
		}
	}
}
