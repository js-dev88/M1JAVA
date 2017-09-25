package TD1;

import java.util.ArrayList;

public class Point {
	private int x;
	private int y;
	private static int compteur = 0;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		compteur++;
	}
	
	public Point(Point point){
		this.x = point.getX();
		this.y = point.getY();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public static int getCompteur(){
		return compteur;
	}
	
	@Override
	public String toString() {
		String s = "(" + x + "," + y +")";
		return s;
	}
	
	public boolean isSameAs(Point p){
		boolean bool  = false;
		if(this.x == p.getX() && this.y == p.getY()){
			bool = true;
		}
		return bool;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Point)) return false;
		return this.isSameAs((Point)obj) == true;
	}
	
	public void translate(int dx, int dy){
		this.x += dx;
		this.y += dy;
		
	}
	
	public static void main(String[] args) {
		/*int i = Point.getCompteur();
		System.out.println(i);
		Point p1 = new Point(5,4);
		int j = Point.getCompteur();
		System.out.println(j);
		System.out.println(p1);
		
		Point p4=new Point(1,2);
		Point p2=p4;
		Point p3=new Point(1,2);
		System.out.println(p4==p2);
		System.out.println(p4==p3);*/
		
		Point p1=new Point(1,2);
		Point p2=p1;
		Point p3=new Point(1,2);
		ArrayList<Point> list = new ArrayList<>();
		list.add(p1);
		System.out.println(list.indexOf(p2));
		System.out.println(list.indexOf(p3));
		
		System.out.println(p1.equals(new String()));
		
	}
	
}