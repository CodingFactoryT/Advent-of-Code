import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5_2021 {

	public static void main(String[] args) {
		Part1();
		Part2();
	}
	
	public static void Part1() {
		String in = new GetInput().getInput(2021, 5);
		
		Matcher matcher = Pattern.compile("([0-9]+),([0-9]+) -> ([0-9]+),([0-9]+)").matcher(in);
		Map<String, Integer> points = new HashMap<>();
		
		while(matcher.find()) {
			Point2D point1 = new Point2D(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
			Point2D point2 = new Point2D(Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));
			
			ArrayList<Point2D> pointsInLine= new ArrayList<>();
			
			if(point1.x == point2.x || point1.y == point2.y) {
				pointsInLine = calculatePointsInLinePart1(point1, point2);
				
				for(Point2D point2D : pointsInLine) {
					String key = point2D.x + "," + point2D.y;
					if(points.containsKey(key)) {
						points.put(point2D.x+","+point2D.y, points.get(key) +1);
					} else {
						points.put(point2D.x+","+point2D.y, 1);
					}
				}
				
				pointsInLine.clear();
			}
		}
		int result = 0;
		
		for(String point : points.keySet()) {
			if(points.get(point) > 1) {
				result++;
			}
		}
		
		System.out.println(result);
	}
	
	public static void Part2() {
		String in = new GetInput().getInput(2021, 5);
		Matcher matcher = Pattern.compile("([0-9]+),([0-9]+) -> ([0-9]+),([0-9]+)").matcher(in);
		Map<String, Integer> points = new HashMap<>();
		
		while(matcher.find()) {
			Point2D point1 = new Point2D(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
			Point2D point2 = new Point2D(Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));
			
			ArrayList<Point2D> pointsInLine= new ArrayList<>();

			if(point1.x == point2.x || point1.y == point2.y) {
				pointsInLine = calculatePointsInLinePart1(point1, point2);
				
				for(Point2D point2D : pointsInLine) {
					String key = point2D.x + "," + point2D.y;
					if(points.containsKey(key)) {
						points.put(point2D.x+","+point2D.y, points.get(key) +1);
					} else {
						points.put(point2D.x+","+point2D.y, 1);
					}
				}	
				pointsInLine.clear();
			} else {
				pointsInLine = calculatePointsInLineDiagonally(point1, point2);
				for(Point2D point2D : pointsInLine) {	
					String key = point2D.x + "," + point2D.y;
					if(points.containsKey(key)) {
						points.put(point2D.x+","+point2D.y, points.get(key) +1);
					} else {
						points.put(point2D.x+","+point2D.y, 1);
					}
				}	
				pointsInLine.clear();
			}
			
		}
	
		
		int result = 0;
		
		for(String point : points.keySet()) {
			if(points.get(point) > 1) {
				result++;
			}
		}
		System.out.println(result);
	}

	private static ArrayList<Point2D> calculatePointsInLinePart1(Point2D point1, Point2D point2) {
		ArrayList<Point2D> pointsInLine= new ArrayList<>();
		if(point1.x == point2.x) {
			int lowesty = 0;
			
			if(point1.y < point2.y) {
				lowesty = point1.y;
			} else {
				lowesty = point2.y;
			}
			
			int distance = Math.abs(point1.y - point2.y);
			
			for(int i = 0; i<= distance; i++) {
				pointsInLine.add(new Point2D(point1.x, lowesty + i));
			}
			
			return pointsInLine;
		}
		if(point1.y == point2.y) {
			int lowestx = 0;
			
			if(point1.x < point2.x) {
				lowestx = point1.x;
			} else {
				lowestx = point2.x;
			}
			
			int distance = Math.abs(point1.x - point2.x);
			
			for(int i = 0; i<= distance; i++) {
				pointsInLine.add(new Point2D(lowestx + i, point1.y));
			}
			
			return pointsInLine;
		}
		return null;
	}
	
	private static ArrayList<Point2D> calculatePointsInLineDiagonally(Point2D point1, Point2D point2) {
		ArrayList<Point2D> pointsInLine= new ArrayList<>();

		int distance = Math.abs(point1.x - point2.x);
		
		if(point1.x < point2.x && point1.y < point2.y) {
			for(int i = 0; i<= distance; i++) {
				pointsInLine.add(new Point2D(point1.x + i, point1.y + i));	
			}
		} 
		
		if(point1.x > point2.x && point1.y < point2.y) {
			for(int i = 0; i<= distance; i++) {
				pointsInLine.add(new Point2D(point1.x - i, point1.y + i));	
			}
		} 
		
		if(point1.x < point2.x && point1.y > point2.y) {
			for(int i = 0; i<= distance; i++) {
				pointsInLine.add(new Point2D(point1.x + i, point1.y - i));	
			}
		} 
		
		if(point1.x > point2.x && point1.y > point2.y) {
			for(int i = 0; i<= distance; i++) {
				pointsInLine.add(new Point2D(point1.x - i, point1.y - i));	
			}
		} 
		
		return pointsInLine;
	}

}

class Point2D {
	int x = 0;
	int y = 0;
	
	Point2D(int x, int y){
		this.x = x;
		this.y = y;
	}

	public Point2D(String string, int y2) {
		// TODO Auto-generated constructor stub
	}
}