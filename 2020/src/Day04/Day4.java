package src.Day04;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {

	public static void main(String[] args) {
		Part1();
		Part2();
	}
	
	public static void Part1() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("2020/Input/Day4_Input.txt"));
			String line;			
			ArrayList<Passport> passports = new ArrayList<>();
			String byr=null,iyr=null,eyr=null,hgt=null,hcl=null,ecl=null,pid=null,cid=null;
			
			while((line = reader.readLine()) != null)						//go through every line						
			{		
				String key = "";
				String value = "";
				String[] split = line.split(" ");

				for(int i = 0; i<split.length; i++) {					//go through every pair in line
						if(!line.isBlank()) {;
							key = split[i].split(":")[0];
							value = split[i].split(":")[1];
							switch(key) {									//check key
							case "byr": byr = value; break;
							case "iyr": iyr = value; break;
							case "eyr": eyr = value; break;
							case "hgt": hgt = value; break;
							case "hcl": hcl = value; break;
							case "ecl": ecl = value; break;
							case "pid": pid = value; break;
							case "cid": cid = value; break;
							}
						}
					}
				
				if(line.isBlank()) {	
					passports.add(new Passport(byr,iyr,eyr,hgt,hcl,ecl,pid,cid));	//add passport to list
					byr=null;														//reset passport
					iyr=null;
					eyr=null;
					hgt=null;
					hcl=null;
					ecl=null;
					pid=null;
					cid=null;
				}
					
			}
			int result = 0;
			for(Passport p : passports) {									//check how many passports are valid
				if(p.isValidPart1()) {
					result++;
				}
			}
			System.out.println(result);
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


public static void Part2() {
	try {
		BufferedReader reader = new BufferedReader(new FileReader("2020/Input/Day4_Input.txt"));
		String line;			
		ArrayList<Passport> passports = new ArrayList<>();
		String byr=null,iyr=null,eyr=null,hgt=null,hcl=null,ecl=null,pid=null,cid=null;

		while((line = reader.readLine()) != null)						//go through every line						
		{		
			String key = "";
			String value = "";
			String[] split = line.split(" ");
			
				for(int i = 0; i<split.length; i++) {					//go through every pair in line
					if(!line.isBlank()) {;
						key = split[i].split(":")[0];
						value = split[i].split(":")[1];
						switch(key) {									//check key
						case "byr": byr = value; break;
						case "iyr": iyr = value; break;
						case "eyr": eyr = value; break;
						case "hgt": hgt = value; break;
						case "hcl": hcl = value; break;
						case "ecl": ecl = value; break;
						case "pid": pid = value; break;
						case "cid": cid = value; break;
						}
					}
				}
			
			if(line.isBlank()) {									
				passports.add(new Passport(byr,iyr,eyr,hgt,hcl,ecl,pid,cid));	//add passport to list
				byr=null;														//reset passport
				iyr=null;
				eyr=null;
				hgt=null;
				hcl=null;
				ecl=null;
				pid=null;
				cid=null;
			}
				
		}
		int result = 0;
		for(Passport p : passports) {									//check how many passports are valid
			if(p.isValidPart2(p)) {
				result++;
			}
		}
		System.out.println(result);
		reader.close();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}




class Passport {
	public String byr = null; 
	public String iyr = null; 
	public String eyr = null; 
	public String hgt = null; 
	public String hcl = null; 
	public String ecl = null; 
	public String pid = null; 
	public String cid = null;
    
	Passport(String byr, String iyr, String eyr, String hgt, String hcl, String ecl, String pid, String cid){
		this.byr = byr;
		this.iyr = iyr;
		this.eyr = eyr;
		this.hgt = hgt;
		this.hcl = hcl;
		this.ecl = ecl;
		this.pid = pid;
		this.cid = cid;
	}
	
    public int countFields() {
    	String[] fields = {byr, iyr, eyr, hgt, hcl, ecl, pid, cid};
    	int count = 0;
    	
    	for(String i : fields) {
    		if(i != null) {
    			count++;
    		}
    	}
    	
    	return count;
    }
    
    public boolean isValidPart1() {
    	int count = this.countFields();
    	
    	if(count == 8 || count == 7 && cid == null) {
    		return true;
    	}
    	
    	return false;
    }
    
    public boolean isValidPart2(Passport p) {
    	int count = this.countFields();
    	
    	if(count == 8 || count == 7 && cid == null) {
    		if(checkRanges(p) && checkHGT(p) && checkHCL(p) && checkECL(p) && checkPID(p)) {
    			return true;
    		}
    	}
    	return false;
    }
   
	public boolean checkRanges(Passport p) {
		if(Integer.parseInt(p.byr) >= 1920 && Integer.parseInt(p.byr) <= 2002
	    && Integer.parseInt(p.iyr) >= 2010 && Integer.parseInt(p.iyr) <= 2020
	    && Integer.parseInt(p.eyr) >= 2020 && Integer.parseInt(p.eyr) <= 2030) {
			return true;
		}
		return false;
	}
	
	public boolean checkHGT(Passport p) {
		int length = p.hgt.length();
		int hgt = 0;
		if(length >= 3) {
			hgt = Integer.parseInt(p.hgt.substring(0,length -2));		
		}
		
		if(p.hgt.contains("cm")) {
			if(hgt >= 150 && hgt <= 193)
				return true;
		} else if(p.hgt.contains("in")) {
			if(hgt >= 59 && hgt <= 76)
				return true;
		}
		return false;
	}

	public boolean checkHCL(Passport p) {
		Matcher matcher = Pattern.compile("#[a-f0-9]{6}").matcher(p.hcl);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
	
	public boolean checkECL(Passport p) {									//funkt nicht
		String allowed[] = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
		for(String i : allowed) {
			if(p.ecl.contains(i)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkPID(Passport p) {
		Matcher matcher = Pattern.compile("[0-9]{9}").matcher(p.pid);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
}
