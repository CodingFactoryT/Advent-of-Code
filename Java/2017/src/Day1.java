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
		char[] input = Files.readString(Paths.get("2017/Input/Day1_Input.txt")).toCharArray();
		int result = 0;
		
		for(int i = 0; i < input.length -1; i++) {		
			if(input[i] == input[i+1]) {
				result += Character.getNumericValue(input[i]);
			}
		}
		
		if(input[input.length -1] == input[0]) {
			result += Character.getNumericValue(input[0]);
		}	
		System.out.println(result);	
	}
	
	public static void Part2() throws IOException {
		char[] input = Files.readString(Paths.get("2017/Input/Day1_Input.txt")).toCharArray();
		int result = 0;
		
		for(int i = 0; i < input.length -1; i++) {		
			if(input[i] == input[(i + input.length/2) % input.length]) {
				result += Character.getNumericValue(input[i]);
			}
		}
		
		if(input[input.length -1] == input[input.length/2]) {
			result += Character.getNumericValue(input[0]);
		}	
		System.out.println(result);	
	}
}
