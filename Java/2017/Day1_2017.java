
public class Day1_2017 {

	public static void main(String[] args) {
		Part1();
		Part2();	
	}

	
	public static void Part1() {
		char[] input = new GetInput().getInput(2017, 1).toCharArray();
		int result = 0;
		
		for(int i = 0; i < input.length -1; i++) {		
			if(input[i] == input[i+1]) {
				result += Character.getNumericValue(input[i]);
			}
		}
		
		if(input[input.length -1] == input[0]) {
			result += Character.getNumericValue(input[0]);
		}	
		System.out.println(result);	
	}
	
	public static void Part2() {
		char[] input = new GetInput().getInput(2017, 1).toCharArray();
		int result = 0;
		CircularArray ar = new CircularArray();
		
		for(int i = 0; i < input.length -1; i++) {		
			if(input[i] == input[ar.moveInArray(i, input.length/2, input.length)]) {
				result += Character.getNumericValue(input[i]);
			}
		}
		
		if(input[input.length -1] == input[input.length/2]) {
			result += Character.getNumericValue(input[0]);
		}	
		System.out.println(result);	
	}
}
