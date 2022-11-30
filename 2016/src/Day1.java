package src;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.*;

public class Day1 {

	public static void main(String[] args) throws IOException {
		Part1();
		Part2();
	}
	
	public static void Part1() throws IOException {
		String input = Files.readString(Paths.get("2016/Input/Day1_Input.txt"));
		String[] inwithoutseperation = input.split(", ");
		Pattern pattern = Pattern.compile("([A-Z])([0-9]+)");
		
		int angle = 0;	
		Point p = new Point();
		
		for(String s : inwithoutseperation) {		
			Matcher matcher = pattern.matcher(s);
			matcher.matches();
			
			char dir = matcher.group(1).charAt(0);
			angle = turn(dir, angle);
			int num = Integer.parseInt(matcher.group(2));
			p = move(num, angle, p);	
		}
		
		int distance = getDistance(p);
		System.out.println(distance);
		

		
	}
	

	public static void Part2() throws IOException {
		String input = Files.readString(Paths.get("2016/Input/Day1_Input.txt"));
		String[] inwithoutseperation = input.split(", ");
		Pattern pattern = Pattern.compile("([A-Z])([0-9]+)");
		ArrayList<Point> points = new ArrayList<Point>();
		int angle = 0;	
		Point p = new Point();
		
		for(String s : inwithoutseperation) {		
			Matcher matcher = pattern.matcher(s);
			matcher.matches();
			
			char dir = matcher.group(1).charAt(0);
			angle = turn(dir, angle);
			int num = Integer.parseInt(matcher.group(2));
			
			for(int i = 0; i<num; i++) {
				p = move(1, angle, p);
				
				if(p.isContainedIn(points)) {
					int distance = getDistance(p);
					System.out.println(distance);
					System.exit(-1);
				}
				
				points.add(new Point(p));
			}
		}
	}
	
	public static int turn(char dir, int angle) {
		
		switch(dir) {			//0=North, 1=East, 2=South, 3=West
		case 'R': angle++; break;
		case 'L': angle--; break;
		default: System.out.println("Something went wrong"); System.exit(-1);
		}
		
		if(angle>3)
			angle = 0;
		
		if(angle<0)
			angle = 3;
		
		return angle;
	}
	
	public static Point move(int num, int angle, Point p) {
		switch(angle) {
		case 0: p.y += num; break;
		case 1: p.x += num; break;
		case 2: p.y -= num; break;
		case 3: p.x -= num; break;
		default: System.out.println("Something went wrong"); System.exit(-2);
		}
		return p;
	}
	
	public static int getDistance(Point p) {
		int distance = Math.abs(p.x) + Math.abs(p.y);
		return distance;
	}
	
}

class Point {
	int x = 0;
	int y = 0;
	
	Point(){
		
	}
	
	Point(Point p){
		this.x = p.x;
		this.y = p.y;
	}
	

	public boolean isContainedIn(ArrayList<Point> list) {
		for(int i = 0; i<list.size(); i++) {
			if(this.x == list.get(i).x && this.y == list.get(i).y){
				return true;
			}
		}
		return false;
	}
}

