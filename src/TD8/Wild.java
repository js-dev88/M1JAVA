package TD8;

import java.util.Arrays;
import java.util.List;

public class Wild {
	
	private static void print(List<? extends Object> list) {
		for (Object o : list)
			System.out.println(o);
	}
	
	private static void size(List<? extends CharSequence> list) {
		for (CharSequence o : list)
			System.out.println(o.length());
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("foo", "toto");
		print(list); //list est de type String et il attend un Objet en argument
		size(list);
	}
	
	
}


 
		