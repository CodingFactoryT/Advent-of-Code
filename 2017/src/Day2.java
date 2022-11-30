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
		String input = Files.readString(Paths.get("2017/Input/Day2_Input.txt"));
		String[] in = input.replaceAll("\r\n", "\t").split("\t");
		int i = 0;
		int result = 0;
		for(int columns = 0; columns<16; columns++) {
			int[] currentLine = new int[16];
			for(int rows = 0; rows<16; rows++) {
				currentLine[rows] = Integer.parseInt(in[i]);
				i++;
			}
			
			int min = currentLine[0];
			int max = currentLine[0];
			
			for(int j : currentLine) {
				if(j < min) {
					min = j;
				}
			}
			for(int j : currentLine) {
				if(j > max) {
					max = j;
				}
			}
			
			int difference = max-min;
			result += difference;
		}
		System.out.println(result);
		

	}

	public static void Part2() throws IOException {
		String input = Files.readString(Paths.get("2017/Input/Day2_Input.txt"));
		String[] in = input.replaceAll("\r\n", "\t").split("\t");
	
		int i = 0;
		int result = 0;
		for(int columns = 0; columns<16; columns++) {
			int[] currentLine = new int[16];
			for(int rows = 0; rows<16; rows++) {
				currentLine[rows] = Integer.parseInt(in[i]);
				i++;
			}
				
			result += getEvenlyDividedNums(currentLine);							
		}
		System.out.println(result);
	}
	
	public static int getEvenlyDividedNums(int[] ar) {
		for(int i = 0; i<ar.length; i++) {
			for(int j = 0; j<ar.length; j++) {
					if(ar[i] % ar[j] == 0 && i!=j) {
						return ar[i]/ar[j];
									
				}
			}
		}
		return -1;
	}

}
