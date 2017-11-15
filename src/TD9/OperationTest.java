package TD9;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperationTest {

	@Test
	public void testOperationPlus() {
		assertEquals("+", Operation.plus.toString());
	}
	
	@Test
	public void testOperationMinus() {
		assertEquals("-", Operation.moins.toString());
	}
	
	@Test 
	public void testComputePlus() {
		assertEquals(5, Operation.plus.compute(2, 3), 0.1);
	}
	
	@Test 
	public void testComputeCombo() {
		assertEquals(9, Operation.plus.compute(Operation.mult.compute(2, 3), 3), 0.1);
	}

}