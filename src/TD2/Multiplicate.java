package TD2;

public class Multiplicate implements Expr {

	private final Expr f1;
	private final Expr f2;
	
	public Multiplicate(Expr v1, Expr v2){
		this.f1 = v1;
		this.f2 = v2;
	}
	
	@Override
	public double eval(){
		/*la valeur d'une addition est la valeur
		 *  de l'expression à gauche et de l'expression
		 *   à droite comme on sait que 
		 * f1 et f2 sont des expr on sait 
		 * qu'on a une méthode eval disponible
		 */
		return f1.eval() * f2.eval();
	}
	
	@Override
	public String toString() {
		return f1.toString() + " * " + f2.toString();
	}
}
