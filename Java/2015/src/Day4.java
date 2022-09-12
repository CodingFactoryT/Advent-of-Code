package src;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {
	

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		Part1();
		Part2();
	}

	
	public static void Part1() throws NoSuchAlgorithmException, IOException {
		String input = Files.readString(Paths.get("2015/Input/Day4_Input.txt"));
		int i = 0;
		while(!getMD5Hash(input + i).startsWith("00000")) {
			i++;
		}
		
		System.out.println(i);
	}
	
	public static void Part2() throws NoSuchAlgorithmException, IOException {
		String input = Files.readString(Paths.get("2015/Input/Day4_Input.txt"));
		int i = 0;
		while(!getMD5Hash(input + i).startsWith("000000")) {
			i++;
		}
		
		System.out.println(i);										//dauert recht lange
	}
	
	public static String getMD5Hash(String str) throws NoSuchAlgorithmException {
		String original = str;
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(original.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
		
	}
}


