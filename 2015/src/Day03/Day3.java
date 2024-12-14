package src.Day03;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Day3 {

	public static void main(String[] args) throws IOException {
		Part1();
	}
	
	public static void Part1() throws IOException {
		String input = Files.readString(Paths.get("2015/Input/Day3_Input.txt"));
		Integer x = 0;
		Integer y = 0;
		HashMap<String, Boolean> result = new HashMap<String, Boolean>();	
		result.put("0,0", true);
		
		for(int i = 0; i<input.length() -1; i++) {
			switch(input.charAt(i+1)) {
				case '^': y++; break;
				case 'v': y--; break;
				case '>': x++; break;
				case '<': x--; break;
			}
			
			String key = x + "," + y;
			
			if(result.get(key) == null) {
			   result.put(key,true);
			  }
		}

		System.out.println(result.size());
		
	}

	
}
