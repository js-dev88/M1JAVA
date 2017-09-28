package TD3;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyListTest {
	public static MyList testset(){
		MyList ml = new MyList();
		ml.addLast("tatu");
		ml.add("totu");
		ml.add("tato");
		return ml;
	}
	
	
	@Test
	public void testSize() {
		MyList ml = MyListTest.testset();
		assertTrue("Size = 3", ml.size() == 3);
	}
	
	@Test
	public void testGet() {
		MyList ml = MyListTest.testset();
		assertTrue("get = totu", ml.get(2) == "totu");
	}

}
