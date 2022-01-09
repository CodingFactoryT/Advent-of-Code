import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day8_2020 {

	public static void main(String[] args) {
		Part1();
//		Part2();
	}
	
	public static void Part1() {
		String input = new GetInput().getInput(2020, 8);	
		int operationAmount = (input.split(" ").length) / 2;
		Matcher matcher = Pattern.compile("([a-z]+) ([+-])([0-9]+)").matcher(input);
		Operation[] operations = new Operation[operationAmount];
		
		int counter = 0;
		
		while(matcher.find()) {
			if(matcher.group(2).contentEquals("-")) {
				operations[counter] = new Operation(matcher.group(1), Integer.parseInt(matcher.group(3)) *-1);
			} else {
				operations[counter] = new Operation(matcher.group(1), Integer.parseInt(matcher.group(3)));
			}
			counter++;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		@SuppressWarnings("unused")
		int accumulator = 0;
		accumulator = executeOperation(operations, 0, list, 0);			
	}
	
	public static int executeOperation(Operation[] ar, int currentIndex, ArrayList<Integer> list, int acc) {
		if(!list.contains(currentIndex)) {
			switch(ar[currentIndex].operation) {
			case "acc": 
				acc += ar[currentIndex].operationValue;
				list.add(currentIndex);
				executeOperation(ar, currentIndex +1, list, acc);
				break;
				
			case "jmp": 
				list.add(currentIndex);
				executeOperation(ar, currentIndex + ar[currentIndex].operationValue, list, acc);
				break;
				
			case "nop":
				list.add(currentIndex);
				executeOperation(ar, currentIndex +1, list, acc);
				break;
			}
			return acc;
			
		} 
		if(list.contains(currentIndex)) {
			System.out.println(acc);
			return acc;
		}
		return -1;
	}
}

class Operation{
	String operation;
	int operationValue;
	
	Operation(String operation, int operationValue){
		this.operation = operation;
		this.operationValue = operationValue;
	}
}
