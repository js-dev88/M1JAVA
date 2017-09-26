package TD2;

class Main {
	public static void main(String[] args) {
		/*Mere mere = new Mere();
		System.out.println(mere.meth);
		mere.printMeth();
		Fille fille = new Fille();
		System.out.println(fille.meth);
		fille.printMeth();
		Mere mereFille = new Fille();
		System.out.println(mereFille.meth);
		mereFille.printMeth();*/
		
		Expr val = new Value(1337.0);
		System.out.println(val.eval()); //affiche 1337.0
		Expr add = new Add(new Value(327.0), val);
		System.out.println(add.eval()); //affiche 1664.0
		Expr e = new Add(new Value(350.0), add);
	    System.out.println(e.eval()); //affiche 2014.0
	    System.out.println(add);
	    Expr sqrt = new SquareRoot(new Value(144));
	    Expr add2 = new Add(new Value(24), sqrt);
	    System.out.println(add2);
	    System.out.println(add2.eval());
	    
	    
	}
}