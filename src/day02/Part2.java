package day02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* week 2 part 2
 *  multiple games, bag with various cubes reside
 *  blue, red, and green of random amounts
 *  in a single game, a few rounds of drawing cubes are played
 *  any number of each can be pulled and shown
 *  establish find fewest number of cubes of each color that could have been in bag to make each game possible
 *  i.e. Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green //this could have been played with 4 red, 2 green, and 6 blue cubes in the bag
 *  once the min number of cubes for a game has been found, multiply them to get the 'power' of the game
 *  find the sum of all the games' powers
 */

public class Part2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sevar\\eclipse-workspace\\adventCode2023\\puzzleInputFiles\\day02\\puzzleInput02_2"));
		int green;
		int blue;
		int red;
		String currentNum;
		String str;
		String currentStr;
		char currentID;
		char currentID2;
		char currentID3;
		int power;
		int colonCheck;
		int result = 0;
		List<String> strList = new ArrayList<String>();
		List<Integer> powerList = new ArrayList<Integer>();
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
			colonCheck = 0;
			green = 0;
			red = 0;
			blue = 0;
			currentNum = null;
			//iterate through each character of a game
			for(int i = 0; i < currentStr.length(); i++) {
				//find game ID number (leftover from part 1)
				if(Character.isDigit(currentStr.charAt(i)) && currentStr.charAt(i) != ':' && colonCheck != -1) {
					if(currentID != 0 && currentID2 == 0) {
						currentID2 = currentStr.charAt(i);
					} else if(currentID2 != 0 && currentID3 == 0) {
						currentID3 = currentStr.charAt(i);
					} else {
						currentID = currentStr.charAt(i);
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
			//multiply and store powers for each game
			power = red * blue * green;
			powerList.add(power);
			
		}
		System.out.println(powerList);
		for(int count = 0; count < powerList.size(); count++) {
			result += powerList.get(count);
		}
		System.out.println("The combined sum of the powers of all games is : " + result);
	}
}
	

