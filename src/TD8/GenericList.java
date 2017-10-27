package TD8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericList {
	
	
	public static List listLengthV3(List<? extends CharSequence> list) {
		ArrayList<Integer> length = new ArrayList<Integer>();
		for (CharSequence c: list) {
			length.add(c.length());
		}
		return length;
	}
	
	public static <T extends CharSequence> List listLengthV2(List<T> list) {
		ArrayList<Integer> length = new ArrayList<Integer>();
		for (T c: list) {
			length.add(c.length());
		}
		return length;
	}

	public static void main(String[] args) {
		
		List l = Arrays.asList("Abd", "del");
		System.out.println(listLengthV3(l));
	}
	
	
}
