package TD9;



import static org.junit.Assert.*;

import java.util.EnumSet;
import java.util.LinkedHashSet;

import org.junit.Test;


public class SwagTest2 {

	/*@Test
	public void testCross() {
		assertEquals("m+i+a+g+e", Swag.swag("miage", EnumSet.of(Style.CROSS)));
	}
	
	@Test
	public void testKikoo() {
		assertEquals("MiAgE", Swag.swag("miage", EnumSet.of(Style.KIKOU)));
	}*/
	
	@Test
	public void testCombo() {
		LinkedHashSet<Style> hs = new LinkedHashSet<Style>();
		hs.add(Style.KIKOU);
		hs.add(Style.CROSS);
		assertEquals("M+i+A+g+E", Swag.swag("miage", hs));
	}

}
