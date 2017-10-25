package TD6;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Panel {
	
	public static Iterator<Integer> panel1( int start, int end){
		return new Iterator<Integer>() {
			private int cursor = start;
			@Override
			public boolean hasNext() {
				
				return cursor <= end;
			}

			@Override
			public Integer next() {
				if(!hasNext()) {
					throw new NoSuchElementException();
				}
				return cursor++;
			}
			
		};
	}
	
	/*public static Iterable<Integer> panel2(int i, int j){
		
		return new Iterable<Integer>() {
			
			@Override
			public Iterator<Integer> iterator() {
				return Panel.panel1(i, j);
			}
		};
		
	}*/
	
	public static List<Integer> panel(int i, int j){
		if( j < i) {
			throw new IllegalArgumentException();
		}
		return new AbstractList<Integer>() {
			
			@Override
			public Integer get(int index) {
				return i + index;
			}

			@Override
			public int size() {
				return j - i+1;
			}
			
		};
	
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		/*Iterator<Integer> it= panel1(1,5);	
		for(;it.hasNext();)
		System.out.println(it.next()); // affiche 1 2 3 4 5	
		for(int i:panel2(1,5))
			System.out.println(i); // affiche 1 2 3 4 5	
		
		List<Integer> l = panel2(3,6);
		
		for(int i:l) {
		System.out.println(i);//affiche 3 4 5 6
		}
		
		System.out.println(l.get(1)); //affiche 4*/
		
		List<Integer> l = panel(3,6);
		for(int i:l) 
		{
		System.out.println(i);
		//affiche 3 4 5 6
		}
		System.out.println(l.get(1)); //affiche 4
	}
}
