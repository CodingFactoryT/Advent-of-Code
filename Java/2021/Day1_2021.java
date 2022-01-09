
public class Day1_2021 {

	public static void main(String[] args) {
		Part1();
		Part2();
	}
	
	public static void Part1() {
		String in = new GetInput().getInput(2021, 1);
		String[] input = in.split(" ");
		
		int result = 0;
		for(int i = 1; i < input.length; i++) {
			if(Integer.parseInt(input[i]) > Integer.parseInt(input[i-1])) {
				result++;
			}
		}
		System.out.println(result);
	}
	
	public static void Part2() {
		String in = new GetInput().getInput(2021, 1);
		String[] input = in.split(" ");

		int result = 0;
		for(int i = 0; i<input.length - 3; i++) {
			int a1 = Integer.parseInt(input[i]);
			int a2 = Integer.parseInt(input[i+1]);
			int a3 = Integer.parseInt(input[i+2]);
			int asum = a1+a2+a3;
			
			int b1 = Integer.parseInt(input[i+1]);
			int b2 = Integer.parseInt(input[i+2]);
			int b3 = Integer.parseInt(input[i+3]);
			int bsum = b1+b2+b3;

			if(asum < bsum) {
				result++;
			}
		}
		System.out.println(result);
	}

}
