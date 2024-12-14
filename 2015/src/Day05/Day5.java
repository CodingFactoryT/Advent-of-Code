package src.Day05;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Day5 {
	
	public static void main(String[] args) throws IOException {
		Part1();
	}
	
	public static void Part1() throws IOException {
		String in = Files.readString(Paths.get("2015/Input/Day5_Input.txt"));
		String[] input = in.split("\n");
		ArrayList<String> niceStrings = new ArrayList<String>();
		
		for(String i : input) {
			if(containsVowels(i, 3) && containsDoubleLetter(i) && !containsForbiddenString(i)) {
				niceStrings.add(i);
			}
		}
		System.out.println(niceStrings.size());
	}
	
	
	public static boolean containsVowels(String str, int amount) {
		int vowelCounter = 0;
		
		for(int i = 0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u') {
				vowelCounter++;
			}
		}
		
		if(vowelCounter >= 3) {
			return true;
		}
				
		return false;
	}
	
	public static boolean containsDoubleLetter(String str) {
		for(int i = 0; i<str.length() -1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				return true;
			}
		}
		
		return false;
	}

	public static boolean containsForbiddenString(String str) {
		if(str.contains("ab") || str.contains("cd") || str.contains("pq") || str.contains("xy")) {
			return true;
		}		
	
	
	return false;
	}
	
}
