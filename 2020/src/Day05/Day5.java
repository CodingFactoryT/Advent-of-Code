package src.Day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day5 {

	public static void main(String[] args) throws IOException {
		Part1();
	}
	
	public static void Part1() throws IOException {
		String in = Files.readString(Paths.get("2020/Input/Day5_Input.txt"));
		String[] input = in.split("\r\n");
		
		int currentLine = 0;
		int currentColumn = 0;
		int[] results = new int[input.length];
		
		for(int i = 0; i<input.length; i++) {
			
			char[] _currentLine = new char[7];
			for(int j = 0; j<7; j++) {
				_currentLine[j] = input[i].charAt(j);
			}
			currentLine = findSeat(_currentLine, 0, 0, 127);
			
			char[] _currentColumn = new char[3];
			_currentColumn[0] = input[i].charAt(7);
			_currentColumn[1] = input[i].charAt(8);
			_currentColumn[2] = input[i].charAt(9);
			currentColumn = findColumn(_currentColumn, 0, 0, 7);					
			
			results[i] = currentLine * 8 + currentColumn;
		}
		
		int highestID = results[0];
		
		for(int i : results) {
			if(i > highestID) {
				highestID = i;
			}
		}
		
		System.out.println(highestID);
		
	}
	

	public static int findSeat(char[] ar, int i, int min, int max) {		//recursive method		
		while(min != max){
			char indicator = ar[i];			
			int middle = (max+min)/2;
			
			switch(indicator) {
			case 'F': 
				max = middle;
				break;
			case 'B': 
				min = middle +1;
				break;	
			}
			i++;
			findSeat(ar, i, min, max);
		}
		return min;
	}
	
	public static int findColumn(char[] ar, int i, int min, int max) {
		while(min != max){

			char indicator = ar[i];			
			int middle = (max+min)/2;
			
			switch(indicator) {
			case 'L': 
				max = middle;
				break;
			case 'R': 
				min = middle +1;
				break;	
			}
			i++;
			
			findColumn(ar, i, min, max);
		}
		return min;
	}

}
