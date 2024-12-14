package src.Day08;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day8 {

	public static void main(String[] args) throws IOException {
		Part1();
		Part2();
	}
	
	public static void Part1() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("2021/Input/Day8_Input.txt"));
		String line;
		int count = 0;
		while((line = reader.readLine()) != null) {
			String[] digetGroups = line.split("\\| ");
			String[] digets = digetGroups[1].split(" ");
			for(String i : digets) {
				if(i.length()==2 || i.length() == 3 || i.length() == 4 || i.length() == 7) {
					count++;
				}
			}
			
		}
		reader.close();
		System.out.println(count);
	}
	
	public static void Part2() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("2021/Input/Day8_Input.txt"));
		String line;
		int result = 0;
		
		while((line = reader.readLine()) != null) {
			String[] digetGroups = line.split("\\| ");
			String[] leftDigets = digetGroups[0].split(" ");
			
			String number1 ="",number3 ="",number4 ="",number6="",number7="",number8="";
			Character a ='@', b='@',c='@',d='@',e='@',f='@',g='@';
			
			for(String i : leftDigets) {
				if(i.length()==2) number1 = i;
				if(i.length()==3) number7 = i;
				if(i.length()==4) number4 = i;
				if(i.length()==7) number8 = i;
			}
			
			for(Character i : number7.toCharArray()) {
				if(!number1.contains(i.toString())) a = i;
			}
			
			char[] charsOfNumber1 = number1.toCharArray();
			for(String i : leftDigets) {
				if(i.length() == 5 && i.contains(String.valueOf(charsOfNumber1[0])) && i.contains(String.valueOf(charsOfNumber1[1]))) {
					number3 = i;
				}
			}		
			int acounter=0, bcounter=0,ccounter=0,dcounter=0,ecounter=0,fcounter=0,gcounter=0;	
			
			for(Character i : number4.toCharArray()) {
				switch(i) {
				case 'a':acounter++; break;
				case 'b':bcounter++; break;
				case 'c':ccounter++; break;
				case 'd':dcounter++; break;
				case 'e':ecounter++; break;
				case 'f':fcounter++; break;
				case 'g':gcounter++; break;
				}
			}
			for(Character i : number1.toCharArray()) {
				switch(i) {
				case 'a':acounter++; break;
				case 'b':bcounter++; break;
				case 'c':ccounter++; break;
				case 'd':dcounter++; break;
				case 'e':ecounter++; break;
				case 'f':fcounter++; break;
				case 'g':gcounter++; break;
				}
			}
			for(Character i : number3.toCharArray()) {
				switch(i) {
				case 'a':acounter++; break;
				case 'b':bcounter++; break;
				case 'c':ccounter++; break;
				case 'd':dcounter++; break;
				case 'e':ecounter++; break;
				case 'f':fcounter++; break;
				case 'g':gcounter++; break;
				}
			}
			if(acounter==2) d = 'a';
			if(bcounter==2) d = 'b';
			if(ccounter==2) d = 'c';
			if(dcounter==2) d = 'd';
			if(ecounter==2) d = 'e';
			if(fcounter==2) d = 'f';
			if(gcounter==2) d = 'g';

			
			for(String i : leftDigets) {
				if(i.length()==6 && (i.contains(String.valueOf(charsOfNumber1[0]))^i.contains(String.valueOf(charsOfNumber1[1])))) {
					number6 = i;
				}
			}
			
			for(Character i : number8.toCharArray()) {
				if(!number6.contains(i.toString())) c = i;
			}
			
			for(Character i : number4.toCharArray()) {
				if(i!=c && i!=d && i!=charsOfNumber1[0] && i!=charsOfNumber1[1]) b = i;
			}
			
			for(Character i : number4.toCharArray()) {
				if(i!=c && i!=d && (i==charsOfNumber1[0] ||i==charsOfNumber1[1])) f = i;
			}
			
			for(Character i : number8.toCharArray()) {
				if(!number3.contains(i.toString()) && i !=b) e=i;
			}
			
			for(Character i : number8.toCharArray()) {
				if(!number4.contains(i.toString()) && i!=a && i!=e) g = i;
			}
			
			String[] rightDigets = digetGroups[1].split(" ");
			String finalNumber = "";

			Mode cont = Mode.contains;
			Mode nCont = Mode.notContains;
			for(String str : rightDigets) {
				if(checkAllChars(str,cont,a,b,c,e,f,g) && checkAllChars(str,nCont,d))finalNumber +="0";
				else if(str.length()==2)finalNumber +="1";
				else if(checkAllChars(str,cont,a,c,d,e,g) && checkAllChars(str,nCont,b,f))finalNumber +="2";
				else if(checkAllChars(str,cont,a,c,d,f,g) && checkAllChars(str,nCont,b,e))finalNumber +="3";
				else if(str.length()==4)finalNumber +="4";
				else if(checkAllChars(str,cont,a,b,d,f,g) && checkAllChars(str,nCont,c,e))finalNumber +="5";
				else if(checkAllChars(str,cont,a,b,d,e,f,g) && checkAllChars(str,nCont,c))finalNumber +="6";
				else if(str.length()==3)finalNumber +="7";
				else if(str.length()==7)finalNumber +="8";
				else if(checkAllChars(str,cont,a,b,c,d,f,g) && checkAllChars(str,nCont,e))finalNumber +="9";
				else System.out.println("Something went wrong: " + str + "   " + a+ " " + b +" " + c + " " + d + " " + e + " " + f+ " " + g);
			}
			result += Integer.parseInt(finalNumber);	
		}	
		reader.close();
		System.out.println(result);	
	}
	
	public static boolean checkAllChars(String original, Mode mode, char... charsToCheck) {
		int count = 0;
		for(Character i : charsToCheck) {
			if(mode == Mode.contains) {
				if(original.contains(i.toString())) count++;				
			} else
				if(!original.contains(i.toString())) count++;				
		}
		if(count >= charsToCheck.length) return true;
		return false;
	}

}

enum Mode{
	contains,
	notContains;
}