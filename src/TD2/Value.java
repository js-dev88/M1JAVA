package TD2;

public class Value implements Expr{
	private double nombre;
	
	public Value(double nombre){
		this.nombre = nombre;
	}
	
	public double eval(){
		return nombre;
	}
	
	@Override
	public String toString() {
		return String.valueOf(nombre);
	}
}
