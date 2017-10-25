package TD4;

import java.util.ArrayList;

public class Bike {
	private final String brand;
	private long value;
	
	public Bike(String brand) {
		this.brand = brand;
	}
	
	public void setValue(long value) {
		this.value = 100;
	}  
	
	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(null);
		l.add(2);
		
		System.out.println(l.toString());
	}
}
