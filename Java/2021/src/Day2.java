package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day2 {

	public static void main(String[] args) throws IOException {
		Part1();
		Part2();
	}
	
	public static void Part1() throws IOException {
		String in = Files.readString(Paths.get("2021/Input/Day2_Input.txt"));
		String[] input = in.split("\r\n| ");
		
		int horizontal = 0;
		int depth = 0;
		
		for(int i = 0; i<input.length; i += 2) {
			int num = Integer.parseInt(input[i+1]);
			
			switch(input[i]) {
			case "forward": horizontal += num; break;
			case "down": depth += num; break;
			case "up": depth -= num; break;
			}
			
		}
		int result = horizontal*depth;
		System.out.println(result);
	}
	
	public static void Part2() throws IOException {
		String in = Files.readString(Paths.get("2021/Input/Day2_Input.txt"));
		String[] input = in.split("\r\n| ");
		
		int horizontal = 0;
		int depth = 0;
		int aim = 0;
		
		for(int i = 0; i<input.length; i = i+2) {
			int num = Integer.parseInt(input[i+1]);
			
			switch(input[i]) {
			case "forward": horizontal += num; depth += aim * num; break;
			case "down": aim += num; break;
			case "up": aim -= num; break;
			}
			
		}
		int result = horizontal*depth;
		System.out.println(result);
	}

}
