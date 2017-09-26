package TD2;
import static org.junit.Assert.*;

import org.junit.Test;

public class ExprTest {

	@Test
	public void eval() {
		Expr sqrt = new SquareRoot(new Value(144));
	    Expr add2 = new Add(new Value(24), sqrt);
	    assertTrue("Add2 est égal à 36",add2.eval() == 36.0);
	}
	

}
