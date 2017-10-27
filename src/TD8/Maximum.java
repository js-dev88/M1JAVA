package TD8;

public class Maximum{
	
	
	@SafeVarargs
	public static <E extends Comparable<E>> E myMax(E firstarg, E ... arguments) {
		
		E max = firstarg;
		
		if( ! (max instanceof Comparable)) {
			throw new IllegalArgumentException("mouimoui");
		};
		
		for(E i : arguments) {
			if( (max).compareTo(i) <= 0) {
				max = i;
			}
		}
		
		return max;
	}
	
	
	public static void main(String[] args) {
		System.out.println(myMax(42,1664)); //1664
		System.out.println(myMax(2014,86,13)); //2014
		//System.out.println(myMax()); //2014
		System.out.println(myMax(8.6,16.64)); //16.64
		System.out.println(myMax("Denis", "Cornaz")); //Denis
		//System.out.println(myMax(8.6, "Denis")); //ne doit pas compiler 
	}



	
}
