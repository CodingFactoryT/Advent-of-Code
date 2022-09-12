package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

	public static void main(String[] args) throws IOException {
		Part1();
	}
	
	public static void Part1() throws IOException {
		String input = Files.readString(Path.of("2018/Input/Day3_Input.txt"));
		String regex = "#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)";
		Matcher matcher = Pattern.compile(regex).matcher(input);
		
		int[][] fabric = new int[1000][1000];
		
		while(matcher.find()) {
			int spaceLeft = Integer.parseInt(matcher.group(2));
			int spaceTop = Integer.parseInt(matcher.group(3));
			int width = Integer.parseInt(matcher.group(4));
			int height = Integer.parseInt(matcher.group(5));
			
			for(int i = spaceTop; i < spaceTop + height; i++) {
				for(int j = spaceLeft; j < spaceLeft + width; j++) {
					fabric[i][j]++;
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < fabric.length; i++) {
			for(int j = 0; j < fabric[0].length; j++) {
				if(fabric[i][j] >= 2) result++;
			}
		}
		System.out.println(result);
	}	

}
