
public class Day2_2017 {

	public static void main(String[] args) {
		Part1();
		Part2();
	}
	
	public static void Part1() {
		String input = new GetInput().getInput(2017, 2);
		String[] in = input.split(" ");

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

	public static void Part2() {
	String input = new GetInput().getInput(2017, 2);
	String[] in = input.split(" ");

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
