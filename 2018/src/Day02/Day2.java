package src.Day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Day2 {

	public static void main(String[] args) throws IOException {
		Part1();
		Part2();
	}
	
	public static void Part1() throws IOException {
		String[] input = Files.readString(Path.of("2018/Input/Day2_Input.txt")).split("\r\n");
		int twoTimesCount = 0;
		int threeTimesCount = 0;
		
		for(String s : input) {
			HashMap<Character, Integer> characterOccurences = new HashMap<>();
			
			for(char c : s.toCharArray()) {
				if(characterOccurences.get(c) == null) {
					characterOccurences.put(c, 1);
				} else {
					characterOccurences.put(c, characterOccurences.get(c) + 1);
				}
			}
			
			if(characterOccurences.containsValue(2)) twoTimesCount++;
			if(characterOccurences.containsValue(3)) threeTimesCount++;
			
		}
		int result = twoTimesCount * threeTimesCount;
		System.out.println(result);
	}
	
	public static void Part2() throws IOException {
		String[] input = Files.readString(Path.of("2018/Input/Day2_Input.txt")).split("\r\n");
		int boxIDLength = input[0].length();
		
		for(int i = 0; i < input.length; i++) {
			for(int j = i+1; j < input.length -1; j++) {
				StringBuilder firstID = new StringBuilder(input[i]);
				StringBuilder secondID = new StringBuilder(input[j]);
				
				int difference = 0;
				
				for(int k = 0; k < firstID.length(); k++) {
					if(firstID.charAt(k) != secondID.charAt(k)) {
						firstID.deleteCharAt(k);
						secondID.deleteCharAt(k);
						k--;
						difference++;
					}
				}
				
				if(difference == 1) {
					System.out.println(firstID);
					return;
				}
			}
		}
	}
}
