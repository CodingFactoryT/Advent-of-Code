package src.Day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day3 {

	public static void main(String[] args) throws IOException {
		Part1();
		Part2();
	}
	
	public static void Part1() throws IOException {
		String in = Files.readString(Paths.get("2020/Input/Day3_Input.txt"));
		String[] inp = in.split("\r\n");
		char[][] input = new char[inp.length][inp[0].length()];
		int index = 0;
		int currentIndex = 0;
		
		for(int i = 0; i<inp.length; i++) {				//2D Array (input) gets filled with it�s values	
			for(int j = 0; j<inp[i].length(); j++) {
				input[i][j] = inp[i].charAt(j);
			}			
		}												//end of filling									
		
		int result = 0;		
		for(int i = 0; i<inp.length; i++) {				//counting trees
			index = currentIndex % inp[i].length();							
			if(input[i][index] == '#') {
				result++;
			}			
			currentIndex += 3;
		}
		System.out.println(result);			
	}
	
	public static void Part2() throws IOException {
		String in = Files.readString(Paths.get("2020/Input/Day3_Input.txt"));
		String[] inp = in.split("\r\n");
		char[][] input = new char[inp.length][inp[0].length()];
		int ind1=0, ind2=0, ind3=0, ind4=0, ind5=0;
		int curInd1=0, curInd2=0, curInd3=0, curInd4=0, curInd5=0;
		
		for(int i = 0; i<inp.length; i++) {				//2D Array (input) gets filled with it�s values	
			for(int j = 0; j<inp[i].length(); j++) {
				input[i][j] = inp[i].charAt(j);
			}			
		}												//end of filling									
		
		long res1=0, res2=0, res3=0, res4=0, res5=0;
		
		for(int i = 0; i<inp.length; i++) {				//counting trees
			ind1 = curInd1 % inp[i].length();			
			if(input[i][ind1] == '#') {
				res1++;
			}			
			curInd1++;
			
				ind2 = curInd2 % inp[i].length();			
				if(input[i][ind2] == '#') {
					res2++;
				}			
				curInd2 += 3;
			
			ind3 = curInd3 % inp[i].length();			
			if(input[i][ind3] == '#') {
				res3++;
			}			
			curInd3 += 5;
			
				ind4 = curInd4 % inp[i].length();			
				if(input[i][ind4] == '#') {
					res4++;
				}			
				curInd4 += 7;
			
			if(i % 2 == 0) {
				ind5 = curInd5 % inp[i].length();			
				if(input[i][ind5] == '#') {
					res5++;
				}			
				curInd5++;
			}
			
		}
		long result = res1*res2*res3*res4*res5;
		System.out.println(result);			
	}

}
