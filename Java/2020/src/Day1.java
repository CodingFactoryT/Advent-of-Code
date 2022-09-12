package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Day1 {

	public static void main(String[] args) throws IOException {
		Part1();
	}

	public static void Part1() throws IOException {
		String[] input = Files.readString(Paths.get("2020/Input/Day1_Input.txt")).split("\r\n");
		HashMap<Integer, String> map = new HashMap<>();
		
		for(String s : input) {
			int val = Integer.parseInt(s);
			
			if(map.get(2020-val) != null) {
				int result = val * (2020-val);
				System.out.println(result);
				return;
			}
			
			map.put(val, "");
		}
	}
}
