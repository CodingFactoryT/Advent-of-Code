package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
public class Day6 {

	public static void main(String[] args) {	
		Part1();
		Part2();
	}
	
	public static void Part1() {		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("2020/Input/Day6_Input.txt"));
			String line;	
			ArrayList<ArrayList<String>> groups = new ArrayList<>();
			
			ArrayList<String> people = new ArrayList<>();
			
			while((line = reader.readLine()) != null) {
				people.add(line);
				
				if(line.isEmpty()) {
					people.remove(people.size() -1);
					groups.add(new ArrayList<String>(people));
					people.clear();
				}
			}
			groups.add(people);
			int result = 0;
			for(int i = 0; i<groups.size(); i++) {
				String str = "";
				for(int j = 0; j<groups.get(i).size(); j++) {
					str += groups.get(i).get(j);
				}
				result += calculateQuestionsAnsweredPart1(str);
			}
			reader.close();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void Part2() {		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("2020/Input/Day6_Input.txt"));
			String line;	
			ArrayList<ArrayList<String>> groups = new ArrayList<>();
			
			ArrayList<String> people = new ArrayList<>();
			
			while((line = reader.readLine()) != null) {
				people.add(line);
				
				if(line.isEmpty()) {
					people.remove(people.size() -1);
					groups.add(new ArrayList<String>(people));
					people.clear();
				}
			}
			groups.add(people);
			int result = 0;
			
			for(int i = 0; i<groups.size(); i++) {
				result += calculateQuestionsAnsweredPart2(groups.get(i));
			}
			reader.close();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static int calculateQuestionsAnsweredPart1(String str) {
		ArrayList<Character> list = new ArrayList<>();
		
		for(int i = 0; i<str.length(); i++) {
			if(!list.contains(str.charAt(i))) {
				list.add(str.charAt(i));
			}
		}
		int amount = list.size();
		return amount;
	}
	
	public static int calculateQuestionsAnsweredPart2(ArrayList<String> list) {
		HashMap<Character, Integer> map = new HashMap<>();
		int amount = 0;
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.get(i).length(); j++) {
				char key = list.get(i).charAt(j);
				if(!map.containsKey(key)) {
					map.put(key, 1);
				} else {
					map.replace(key, map.get(key) + 1);
				}
			}
		}
		for(Character c : map.keySet()) {
			if(map.get(c) >= list.size()) {
				amount++;
			}
		}
		return amount;
	}

}
