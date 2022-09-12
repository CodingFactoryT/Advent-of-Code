package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day1 {
		public static void main(String[] args) throws IOException {
			Part1();
			Part2();
		}
		
		public static void Part1() throws IOException {
			String input_ = Files.readString(Paths.get("2019/Input/Day1_Input.txt"));
			String[] input = input_.split("\r\n");
			
			int result = 0;
			for(int i = 0; i<input.length; i++) {
				result += Integer.parseInt(input[i])/3-2;
			}
			
			System.out.println(result);
		}
		
		public static void Part2() throws IOException {
			String input_ = Files.readString(Paths.get("2019/Input/Day1_Input.txt"));
			String[] input = input_.split("\r\n");
			
			int result = 0;
			for(int i = 0; i<input.length; i++) {
				int thisresult = 0;
				thisresult += Integer.parseInt(input[i])/3-2;
				int lastresult = thisresult;
				
				while(lastresult/3-2 >= 0) {
					thisresult += lastresult/3-2;
					lastresult = lastresult/3-2;
				}
				result += thisresult;
			}
			
			System.out.println(result);
		}
}
