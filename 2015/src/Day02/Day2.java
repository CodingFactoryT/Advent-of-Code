package src.Day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day2 {

	public static void main(String[] args) throws IOException {
		Part1();
		Part2();
	}
	
	public static void Part1() throws IOException {
		String[] input = Files.readString(Paths.get("2015/Input/Day2_Input.txt")).split("\r\n");
		int result = 0;
		
		for(String s : input) {
			int l = Integer.parseInt(s.split("x")[0]);
			int w = Integer.parseInt(s.split("x")[1]);
			int h = Integer.parseInt(s.split("x")[2]);
			
			int lw = l*w;
			int wh = w*h;
			int hl = h*l;
			
			int extra = Math.min(lw, Math.min(wh, hl));
			
			result += 2*(lw+wh+hl) + extra;
		}
		
		System.out.println(result);
	}
	
	public static void Part2() throws IOException {
		String[] input = Files.readString(Paths.get("2015/Input/Day2_Input.txt")).split("\r\n");
		int result = 0;

		for(String s : input) {
			int l = Integer.parseInt(s.split("x")[0]);
			int w = Integer.parseInt(s.split("x")[1]);
			int h = Integer.parseInt(s.split("x")[2]);
			
			int bow = l*w*h;
			
			result += 2*(l+w+h) + bow - 2*Math.max(l, Math.max(w, h));
		}
		
		System.out.println(result);
	}
}
