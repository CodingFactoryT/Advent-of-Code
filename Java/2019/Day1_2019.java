
public class Day1_2019 {
		public static void main(String[] args) {
			Part1();
			Part2();
		}
		
		public static void Part1() {
			String input_ = new GetInput().getInput(2019, 1);
			String[] input = input_.split(" ");
			
			int result = 0;
			for(int i = 0; i<input.length; i++) {
				result += Integer.parseInt(input[i])/3-2;
			}
			
			System.out.println(result);
		}
		
		public static void Part2() {
			String input_ = new GetInput().getInput(2019, 1);
			String[] input = input_.split(" ");
			
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
