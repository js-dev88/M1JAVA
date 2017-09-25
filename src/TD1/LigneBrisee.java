package TD1;

import java.util.LinkedList;


public class LigneBrisee {
	
	private LinkedList<Point> tableauPoint;
	//private int index = 0;
	
	public LigneBrisee(/*int capacite*/) {
		this.tableauPoint = new LinkedList<Point>();
	}
	
	public void add(Point p){
		/*if(index + 1  == tableauPoint.length){
			throw new IndexOutOfBoundsException();
		}
		tableauPoint[this.index] = Objects.requireNonNull(p);
		index++;*/
		tableauPoint.add(p);
		
		
	}
	
	/*public int pointCapacity(){
		return tableauPoint.size();
	}*/
	
	public int nbPoints(){
		//return index+1;
		return tableauPoint.size();
	}
	
	public boolean contains(Point p){
		/*Boolean bool = false;
		for(Point point: tableauPoint){
			if(p.equals(point)){
				bool = true;
			}
		}
		return bool;*/
		return tableauPoint.contains(p);
	}
	
	public static void main(String[] args) {
	   Point p1 = new Point(5,4);
	   Point p2 = p1;
	   Point p3 = new Point(5,4);
	   LigneBrisee lb = new LigneBrisee();
	   lb.add(p1);
	   lb.contains(p1);
	   System.out.println(lb.contains(p1));
	   System.out.println(lb.contains(p2));
	   System.out.println(lb.contains(p3));
	}
	
}