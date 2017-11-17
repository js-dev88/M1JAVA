package TD9;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Bag <E> implements Iterable<Map.Entry<E, Integer>>{
	
	
	private Map<E, Integer> bag = new HashMap<>();
	
	public Bag() {
		this.bag = new HashMap<E, Integer>();
	}
	
	public void add(E element) {
		if(bag.containsKey(element)) 
			bag.put(element, count(element)+1);
		else
			bag.put(element, 1);
	}
	
	public void remove(E element) {
		
		if(bag.containsKey(element)) {
			bag.put(element, count(element)-1);
		}else {
			bag.remove(element);
		}
		
	}
	
	public int count(E element) {
		if(bag.containsKey(element)) {
			return bag.get(element);
		}else {
			return 0;
		}
		
	}
	
	public Iterator<Map.Entry<E,Integer>> iterator(){
		return bag.entrySet().iterator();
	}
	
	
	public static void main(String[] args) {
		Bag<String> bag = new Bag<>();
		bag.add("toto");
		System.out.println(bag.count("toto"));
	}

	

	

}
