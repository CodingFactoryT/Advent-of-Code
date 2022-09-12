package src;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Day3 {

	public static void main(String[] args) throws IOException {
		Part1();
		Part2();
	}
	
	public static void Part1() throws IOException {
		String in = Files.readString(Paths.get("2021/Input/Day3_Input.txt"));
		String[] input = in.split("\r\n");
		String result_bytes = new String();
		
		for(int i = 0; i<input[0].length(); i++) {
			int zero_counter = 0;
			int one_counter = 0;
			
			for(int j = 0; j<input.length; j++) {
				if(input[j].charAt(i) == '0') {
					zero_counter++;
				} else {
					one_counter++;
				}
			}
			
			if(zero_counter > one_counter) {
					result_bytes += 0;				
			} else {			
					result_bytes += 1;
			}
		}
		
		int gamma_rate = Integer.parseInt(result_bytes, 2);
		result_bytes = result_bytes.replaceAll("0", "X").replaceAll("1", "0").replaceAll("X", "1");
		int epsilon_rate = Integer.parseInt(result_bytes, 2);
		
		int result = gamma_rate * epsilon_rate;
		System.out.println(result);
	}
	
	public static void Part2() throws IOException {
		String in = Files.readString(Paths.get("2021/Input/Day3_Input.txt"));
		String[] inp = in.split("\r\n");
		ArrayList<String> byteList1 = new ArrayList<String>();
		ArrayList<String> byteList2 = new ArrayList<String>();
		for(String i : inp) {
			byteList1.add(i);
			byteList2.add(i);
		}
		
		String oxygen_generator_rating_str = find_oxygen_generator_rating(byteList1, " ", 0);	
		String co2_scrubber_rating_str = find_co2_scrubber_rating(byteList2, " ", 0);
		int oxygen_generator_rating = Integer.parseInt(oxygen_generator_rating_str, 2);
		int co2_scrubber_rating = Integer.parseInt(co2_scrubber_rating_str, 2);
		
		int result = oxygen_generator_rating * co2_scrubber_rating;
		System.out.println(result);

	}
	
	public static String find_oxygen_generator_rating(ArrayList<String> ar, String result, int index) {
		if(ar.size() <= 1) //base case
		{
			result = ar.get(0);
			return result;
		}
		
		int zero_counter = 0;
		int one_counter = 0;
		
		for(int j = 0; j<ar.size(); j++) {
			if(ar.get(j).charAt(index) == '0') {
				zero_counter++;
			} else {
				one_counter++;
			}
		}
		
		if(zero_counter < one_counter) {
			ar = removeCharIfEquals('0', ar, index);
		}
		else if(one_counter < zero_counter) {
			ar = removeCharIfEquals('1', ar, index);
		}
		else if(one_counter == zero_counter) {
			ar = removeCharIfEquals('0', ar, index);
		}
		else
			System.out.println("An error accured!");
			
		ArrayList<String> temp = new ArrayList<>();
		
		for(int i = 0; i<ar.size(); i++) {
			if(ar.get(i) == "no resulting") {
				temp.add(ar.get(i));
			}
			
		}

		ar.removeAll(temp);

		return find_oxygen_generator_rating(ar, result, index +1);
	}
	
	public static String find_co2_scrubber_rating(ArrayList<String> ar, String result, int index) {
		if(ar.size() <= 1) //base case
		{
			result = ar.get(0);
			return result;
		}
		
		int zero_counter = 0;
		int one_counter = 0;
		
		for(int j = 0; j<ar.size(); j++) {
			if(ar.get(j).charAt(index) == '0') {
				zero_counter++;
			} else {
				one_counter++;
			}
		}
		
		if(zero_counter > one_counter) {
			ar = removeCharIfEquals('0', ar, index);
		}
		else if(one_counter > zero_counter) {
			ar = removeCharIfEquals('1', ar, index);
		}
		else if(one_counter == zero_counter) {
			ar = removeCharIfEquals('1', ar, index);
		}
		else
			System.out.println("An error accured!");
			
		ArrayList<String> temp = new ArrayList<>();
		
		for(int i = 0; i<ar.size(); i++) {
			if(ar.get(i) == "no resulting") {
				temp.add(ar.get(i));
			}
			
		}

		ar.removeAll(temp);

		return find_co2_scrubber_rating(ar, result, index +1);
		
	}
	
	public static ArrayList<String> removeCharIfEquals(char c, ArrayList<String> ar, int index) {

		for(int i = 0; i < ar.size(); i++) {
			
				if(ar.get(i).charAt(index) == c) {
					ar.set(i,"no resulting");	
				}
		}
		return ar;
	}
}
