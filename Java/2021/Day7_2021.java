import java.util.Arrays;

public class Day7_2021 {

	public static void main(String[] args) {
		getMinFuel("Part1");
		getMinFuel("Part2");
	}
	
	public static void getMinFuel(String part) {
		String in = new GetInput().getInput(2021, 7);
		String[] inp = in.split(",");
		int[] input = new int[inp.length];
		
		for(int i = 0; i < inp.length; i++) {
			input[i] = Integer.parseInt(inp[i]);
		}
		
		int max = Arrays.stream(input).max().getAsInt();	
		int lowestFuel = 1000000000;
		
		for(int i = 0; i < max ; i++) {
			int fuel = 0;
			for(int j : input) {
				int steps = Math.abs(j-i);
				
				if(part.equals("Part1")) {		
					fuel += steps;
				} else {
					int currentFuel = steps*(steps+1)/2;
					fuel += currentFuel;
				}
			}
			if(fuel < lowestFuel) {
				lowestFuel = fuel;
			}
		}		
		System.out.println(lowestFuel);
	}
}
