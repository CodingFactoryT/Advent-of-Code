package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class Day1 {
	public static void main(String[] args) throws IOException {
		Part1();
		Part2();
	}
	
	public static void Part1() throws IOException {
		String[] inputNumbers = Files.readString(Path.of("2018/Input/Day1_Input.txt")).split("\r\n");
		int result = 0;
		for(String s : inputNumbers) {
			result += Integer.parseInt(s);
		}
		System.out.println(result);
	}
	
	public static void Part2() throws IOException {
		String[] inputNumbers = Files.readString(Path.of("2018/Input/Day1_Input.txt")).split("\r\n");
		HashMap<Integer, String> frequenciesSeen = new HashMap<>();
		
		int result = 0;
		
		while(true) {
			for(String s : inputNumbers) {
				result += Integer.parseInt(s);

				if(frequenciesSeen.get(result) != null) {
					System.out.println(result);
					return;
				}
				
				frequenciesSeen.put(result, "");
			}
		}
	}
}
