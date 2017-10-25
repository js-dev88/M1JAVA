package TD6;

import java.util.ArrayList;
import java.util.List;

public class Mult {
	

	
	public List<Integer> mult(Integer entier, List<Integer> listeEntier) {
		List<Integer> mabite = new ArrayList<>();
		for(int i : listeEntier) {
			mabite.add(i*  entier);
		}
		return mabite;
	}
	
	public static void main(String[] args) {
		Mult m = new Mult();
		List<Integer> l = new ArrayList();
		for(int i =0; i <= 99; i++) {
			l.add(i);
		}
		
		System.out.println(m.mult(2, l).toString());
		
		
	}
}
