package src;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day6 {

	public static void main(String[] args) throws IOException {
		calculateFishAmount(80);		//Part 1, fish after 80 days
		calculateFishAmount(256);		//Part 2, fish after 256 days;
	}
	
	public static void calculateFishAmount(int days) throws IOException {
		String in = Files.readString(Path.of("2021/Input/Day6_Input.txt"));
		String[] input = in.split(",");
		
		long fish_0 = 0,fish_1 = 0,fish_2 = 0,fish_3 = 0,fish_4 = 0,fish_5 = 0,fish_6 = 0,fish_7 = 0,fish_8 = 0;
		BigInteger totalFish = new BigInteger("0");
		
		for(String i : input) {
			switch(i) {
			case "1": fish_1++; break;
			case "2": fish_2++; break;
			case "3": fish_3++; break;
			case "4": fish_4++; break;
			case "5": fish_5++; break;
			case "6": fish_6++; break;
			case "7": fish_7++; break;
			case "8": fish_8++; break;
			}
		}
		
		totalFish = BigInteger.valueOf(fish_0 + fish_1 + fish_2 + fish_3 + fish_4 + fish_5 + fish_6 + fish_7 + fish_8); 
		for(int i = 0; i < days; i++) {
			long temp_fish0 = fish_0;
			fish_0 = fish_1;
			fish_1 = fish_2;
			fish_2 = fish_3;
			fish_3 = fish_4;
			fish_4 = fish_5;
			fish_5 = fish_6;
			fish_6 = fish_7 + temp_fish0;
			fish_7 = fish_8;
			fish_8 = temp_fish0;
			
			totalFish = BigInteger.valueOf(fish_0 + fish_1 + fish_2 + fish_3 + fish_4 + fish_5 + fish_6 + fish_7 + fish_8); 
		}
		
		System.out.println(totalFish);
	}
}