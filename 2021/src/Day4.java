package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day4 {

	public static void main(String[] args) throws IOException {
		Part1();			//only run one of the two Parts at a time because both call System.exit()
	  //Part2();
	}
	
	public static void Part1() throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader("2021/Input/Day4_Input.txt"));
		String line = reader.readLine();	

		ArrayList<Integer> selectedNumbers = getSelectedNumbers(reader, line);

		ArrayList<Board> boards = getBoards(reader, line);
		for(int j = 0; j < selectedNumbers.size(); j++) {
			
			for(int z = 0; z < boards.size(); z++) {
				Board board = new Board();
				board = boards.get(z);
				for(int y = 0; y < 25; y++) {
					if(board.numberValues[y] == selectedNumbers.get(j)) {
						board.numberSelected[y] = true;	
					}		
				}
				
				if(hasWon(board)) {
					int unmarkedSum = 0;
					for(int a = 0; a < 25; a++) {
						if(!board.numberSelected[a]) {
							unmarkedSum += board.numberValues[a];
						}
					}
					int result = unmarkedSum * selectedNumbers.get(j);
					System.out.println(result);
					System.exit(0);
				} 
					
				
			}
		}
	
	}
	
	public static void Part2() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("2021/Input/Day4_Input.txt"));
		String line = reader.readLine();	

		ArrayList<Integer> selectedNumbers = getSelectedNumbers(reader, line);
		ArrayList<Board> boards = getBoards(reader, line);
		ArrayList<Board> winningBoards = new ArrayList<>();
		for(int j = 0; j < selectedNumbers.size(); j++) {
			
			for(int z = 0; z < boards.size(); z++) {
				Board board = new Board();
				board = boards.get(z);
				for(int y = 0; y < 25; y++) {
					if(board.numberValues[y] == selectedNumbers.get(j)) {
						board.numberSelected[y] = true;	
					}		
				}
				
				if(hasWon(board)) {
					int unmarkedSum = 0;
					for(int a = 0; a < 25; a++) {
						if(!board.numberSelected[a]) {
							unmarkedSum += board.numberValues[a];
						}
					}
					
					if(!winningBoards.contains(board)) {
						winningBoards.add(board);
					}
					if(winningBoards.size() == boards.size()) {
						int result = unmarkedSum * selectedNumbers.get(j);
						System.out.println(result);
						System.exit(0);
					}
				} 			
				
			}
		}
		
	}
	
	public static ArrayList<Integer> getSelectedNumbers(BufferedReader reader, String line) throws IOException{
		String[] numbers = line.split(",");
		ArrayList<Integer> selectedNumbers = new ArrayList<>();
		
		for(String number : numbers) {
			selectedNumbers.add(Integer.parseInt(number));
		}
		return selectedNumbers;
	}
	
	public static ArrayList<Board> getBoards(BufferedReader reader, String line) throws IOException {
		ArrayList<Board> boards = new ArrayList<Board>();

		Board board = new Board();
		int count = 0;
		reader.readLine();
		while((line = reader.readLine()) != null) {
			if(!line.isBlank()) {			
					String[] numbersInLine = line.split(" ");
					for(int i = 0; i < numbersInLine.length; i++) {
						if(!numbersInLine[i].equals("")) {
							board.numberValues[count] = Integer.parseInt(numbersInLine[i]);
							board.numberSelected[count] = false;
							count++;
						}		
				}
			} else {
				boards.add(new Board(board.numberValues, board.numberSelected));
				board = new Board();
				count = 0;
			}
		}
		return boards;
	}
	
	public static boolean hasWon(Board board) {
		boolean[] sel = board.numberSelected;

		if(sel[0]==true && sel[1]==true && sel[2]==true && sel[3]==true && sel[4]==true) return true;
		if(sel[5]==true && sel[6]==true && sel[7]==true && sel[8]==true && sel[9]==true) return true;
		if(sel[10]==true && sel[11]==true && sel[12]==true && sel[13]==true && sel[14]==true) return true;	//horizontal check
		if(sel[15]==true && sel[16]==true && sel[17]==true && sel[18]==true && sel[19]==true) return true;
		if(sel[20]==true && sel[21]==true && sel[22]==true && sel[23]==true && sel[24]==true) return true;
		
		if(sel[0]==true && sel[5]==true && sel[10]==true && sel[15]==true && sel[20]==true) return true;
		if(sel[1]==true && sel[6]==true && sel[11]==true && sel[16]==true && sel[21]==true) return true;
		if(sel[2]==true && sel[7]==true && sel[12]==true && sel[17]==true && sel[22]==true) return true;	//vertical check
		if(sel[3]==true && sel[8]==true && sel[13]==true && sel[18]==true && sel[23]==true) return true;
		if(sel[4]==true && sel[9]==true && sel[14]==true && sel[19]==true && sel[24]==true) return true;
		
		return false;	//if the board does not win
	}

}

class Board {
	int[] numberValues = new int[25];
	boolean[] numberSelected = new boolean[25];
	
	Board(){}
	
	Board(int[] numberValues, boolean[] numerSelected){
		this.numberValues = numberValues;
		this.numberSelected = numerSelected;
	}
	
}
