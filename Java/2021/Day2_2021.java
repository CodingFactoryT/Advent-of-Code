
public class Day2_2021 {

	public static void main(String[] args) {
		Part1();
		Part2();
	}
	
	public static void Part1() {
		String in = new GetInput().getInput(2021, 2);
		String[] input = in.split(" ");
		
		int horizontal = 0;
		int depth = 0;
		
		for(int i = 0; i<input.length; i = i+2) {
			int num = Integer.parseInt(input[i+1]);
			
			switch(input[i]) {
			case "forward": horizontal += num; break;
			case "down": depth += num; break;
			case "up": depth -= num; break;
			}
			
		}
		int result = horizontal*depth;
		System.out.println(result);
	}
	
	public static void Part2() {
		String in = new GetInput().getInput(2021, 2);
		String[] input = in.split(" ");
		
		int horizontal = 0;
		int depth = 0;
		int aim = 0;
		
		for(int i = 0; i<input.length; i = i+2) {
			int num = Integer.parseInt(input[i+1]);
			
			switch(input[i]) {
			case "forward": horizontal += num; depth += aim * num; break;
			case "down": aim += num; break;
			case "up": aim -= num; break;
			}
			
		}
		int result = horizontal*depth;
		System.out.println(result);
	}

}
