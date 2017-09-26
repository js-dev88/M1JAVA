package TD2;

public class SquareRoot implements Expr{
	
	private final Expr f1;

	
	public SquareRoot(Expr v1){
		this.f1 = v1;
	
	}
	
	@Override
	public double eval(){
		/*la valeur d'une addition est la valeur
		 *  de l'expression à gauche et de l'expression
		 *   à droite comme on sait que 
		 * f1 et f2 sont des expr on sait 
		 * qu'on a une méthode eval disponible
		 */
		return Math.sqrt(f1.eval()) ;
	}
	
	@Override
	public String toString() {
		return "\u221a" + f1.toString() ;
	}
}
