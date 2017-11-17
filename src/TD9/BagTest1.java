package TD9;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;


public class BagTest1 {

	@Test
	public void testCount1() {
		Bag<String> bag = new Bag<>();
		bag.add("toto");
		assertEquals(1, bag.count("toto"));
	}
	
	@Test
	public void testCount2() {
		Bag<String> bag = new Bag<>();
		bag.add("toto");
		bag.add("toto");
		bag.remove("toto");
		assertEquals(1, bag.count("toto"));
	}
	
	@Test
	public void testCount3() {
		Bag<String> bag = new Bag<>();
		bag.add("toto");
		bag.add("toto");
		assertEquals(2, bag.count("toto"));
	}
	
	@Test
	public void testCount4() {
		Bag<Integer> bag = new Bag<>();
		bag.add(2);
		bag.add(2);
		bag.remove(2);
		bag.remove(2);
		
		assertEquals(0, bag.count(2));
	}
	/*
	@Test
	public void testOrder() {
		Bag<String> bag = new Bag<>(BagOrder.NATURAL);
		bag.add("zz");
		bag.add("aa");
		bag.add("zz");
		bag.add("d");
		
		Iterator<Map.Entry<String, Integer>> it = bag.iterator();
		assertEquals("aa", it.next().getKey());
		assertEquals("d", it.next().getKey());
		Entry<String, Integer> entry = it.next();
		assertEquals("zz", entry.getKey());
		assertEquals(new Integer(2), entry.getValue());
	}
	
	@Test
	public void testOrder2() {
		Bag<String> bag = new Bag<>(BagOrder.INSERT);
		bag.add("zz");
		bag.add("aa");
		bag.add("zz");
		bag.add("d");
		
		Iterator<Map.Entry<String, Integer>> it = bag.iterator();
		Entry<String, Integer> entry = it.next();
		assertEquals("zz", entry.getKey());
		assertEquals(new Integer(2), entry.getValue());
		assertEquals("aa", it.next().getKey());
		assertEquals("d", it.next().getKey());
	}*/
}