package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day2 {

	public static void main(String[] args) throws IOException {
		Part1();
	}
	
	public static void Part1() throws IOException {
		String[] input = Files.readString(Paths.get("2016/Input/Day2_Input.txt")).split("\r\n");
		String code = "";
		String[][] numericKeypad = new String[][] {
				{"1", "2", "3"},
				{"4", "5", "6"},
				{"7", "8", "9"}
		};

		for(String s : input) {
			int xIndex = 1;
			int yIndex = 1;
			for(char c : s.toCharArray()) {
				if(c == 'U' && yIndex != 0)
					yIndex--;
				if(c == 'D' && yIndex != 2)
					yIndex++;
				if(c == 'L' && xIndex != 0)
					xIndex--;
				if(c == 'R' && xIndex != 2)
					xIndex++;
			}
			code += numericKeypad[yIndex][xIndex];
		}
		System.out.println(code);
	}
}
