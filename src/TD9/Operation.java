package TD9;

public enum Operation {
	plus('+'){
		@Override
		public double compute(double n1, double n2) {
			return n1 + n2;
		}
	}, 
	moins('-'){
		@Override
		public double compute(double n1, double n2) {
			return n1 - n2;
		}
	}, 
	mult('*'){
		@Override
		public double compute(double n1, double n2) {
			return n1 * n2;
		}
	}, 
	divise('/'){
		@Override
		public double compute(double n1, double n2) {
			if(n2 == 0) {
				throw new IllegalArgumentException("Abdel");
			}
			return n1 / n2;
		}
	};
	
	private final char signe;
	
	Operation(char signe){
		this.signe = signe;
	}
	
	

	public abstract double compute(double n1, double n2);
	
	@Override
	public String toString() {
		return String.valueOf(signe);
	} 
	
	
	public static void main(String[] args) {

		System.out.println(Operation.plus);
		System.out.println(Operation.plus.compute(1, 2));
		
	}
}
