package TD4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest2 {

	@Test
	public void testGetBrand() {
		Car car = new Car("Ferrari", "01245678",40000);
		assertEquals("Ferrari", car.getBrand());
	}
	
	@Test
	public void testGetValue() {
		Car car = new Car("Ferrari", "01245678",40000);
		assertEquals(40000, car.getValue());
	}

}
