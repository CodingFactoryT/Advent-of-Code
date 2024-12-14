package src.Day06;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day6 {

	public static void main(String[] args) throws IOException {
		Part1();
		Part2();
	}
	
	public static void Part1() throws IOException {
		String regex = "([a-z]+) ?([a-z]+) ([0-9]+),([0-9]+) through ([0-9]+),([0-9]+)";
		String input = Files.readString(Paths.get("2015/Input/Day6_Input.txt"));
		Matcher matcher = Pattern.compile(regex).matcher(input);
		
		boolean[][] lights = new boolean[1000][1000];
		
		while(matcher.find()) {
			int fromX = Integer.parseInt(matcher.group(3));
			int fromY = Integer.parseInt(matcher.group(4));
			int toX   = Integer.parseInt(matcher.group(5));
			int toY   = Integer.parseInt(matcher.group(6));
			
			if(matcher.group(1).contentEquals("turn")) {
				if(matcher.group(2).contentEquals("on")) {
					lights = turnOnPart1(lights, fromX, fromY, toX, toY);
				} else {
					lights = turnOffPart1(lights, fromX, fromY, toX, toY);
				}
			} else {
				lights = togglePart1(lights, fromX, fromY, toX, toY);
			}
		}
		
		int result = 0;
		for(int i = 0; i < lights.length; i++) {
			for(int j = 0; j < lights[i].length; j++) {
				if(lights[i][j] == true) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
	
	public static void Part2() throws IOException {
		String regex = "([a-z]+) ?([a-z]+) ([0-9]+),([0-9]+) through ([0-9]+),([0-9]+)";
		String input = Files.readString(Paths.get("2015/Input/Day6_Input.txt"));
		Matcher matcher = Pattern.compile(regex).matcher(input);
		
		int[][] lights = new int[1000][1000];
		
		while(matcher.find()) {
			int fromX = Integer.parseInt(matcher.group(3));
			int fromY = Integer.parseInt(matcher.group(4));
			int toX   = Integer.parseInt(matcher.group(5));
			int toY   = Integer.parseInt(matcher.group(6));
			
			if(matcher.group(1).contentEquals("turn")) {
				if(matcher.group(2).contentEquals("on")) {
					lights = turnOnPart2(lights, fromX, fromY, toX, toY);
				} else {
					lights = turnOffPart2(lights, fromX, fromY, toX, toY);
				}
			} else {
				lights = togglePart2(lights, fromX, fromY, toX, toY);
			}
		}
		
		int result = 0;
		for(int i = 0; i < lights.length; i++) {
			for(int j = 0; j < lights[i].length; j++) {
					result += lights[i][j];
			}
		}
		System.out.println(result);
	}
	
	public static boolean[][] turnOnPart1(boolean[][] ar, int fromX, int fromY, int toX, int toY) {
		for(int i = fromX; i <= toX; i++) {
			for(int j = fromY; j <= toY; j++) {
				ar[i][j] = true;
			}
		}		
		return ar;
	}
	
	public static boolean[][] turnOffPart1(boolean[][] ar, int fromX, int fromY, int toX, int toY) {
		for(int i = fromX; i <= toX; i++) {
			for(int j = fromY; j <= toY; j++) {
				ar[i][j] = false;
			}
		}			
		return ar;
	}
	
	public static boolean[][] togglePart1(boolean[][] ar, int fromX, int fromY, int toX, int toY) {
		for(int i = fromX; i <= toX; i++) {
			for(int j = fromY; j <= toY; j++) {
				ar[i][j] = !ar[i][j];				
			}
		}				
		return ar;
	}
	
	public static int[][] turnOnPart2(int[][] ar, int fromX, int fromY, int toX, int toY) {
		for(int i = fromX; i <= toX; i++) {
			for(int j = fromY; j <= toY; j++) {
					ar[i][j] += 1;			
			}
		}		
		return ar;
	}
	
	public static int[][] turnOffPart2(int[][] ar, int fromX, int fromY, int toX, int toY) {
		for(int i = fromX; i <= toX; i++) {
			for(int j = fromY; j <= toY; j++) {
				if(ar[i][j] > 0) {
					ar[i][j] -= 1;			
				}
			}
		}			
		return ar;
	}
	
	public static int[][] togglePart2(int[][] ar, int fromX, int fromY, int toX, int toY) {
		for(int i = fromX; i <= toX; i++) {
			for(int j = fromY; j <= toY; j++) {
				ar[i][j] += 2;				
			}
		}				
		return ar;
	}

}
