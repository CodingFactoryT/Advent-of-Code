package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day1 {

	public static void main(String[] args) throws IOException {
		Part1();
		Part2();
	}
	
	public static void Part1() throws IOException {
		String input = Files.readString(Paths.get("2015/Input/Day1_Input.txt"));
		
		int floor = 0;
		for(char c : input.toCharArray()) {
			if(c == '(') floor++;
			else floor--;
		}
		System.out.println(floor);
	}
	
	public static void Part2() throws IOException {
		String input = Files.readString(Paths.get("2015/Input/Day1_Input.txt"));
		
		int floor = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(') floor++;
			else floor--;
			
			if(floor == -1) {
				System.out.println(i+1);
				return;
			}
		}
	}

}
