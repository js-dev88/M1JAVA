package TD1;

public class Circle {
	private Point p;
	private double rayon;
	
	public Circle(Point p, double rayon){
		this.p = new Point(p);
		this.rayon = rayon;
	}
	
	@Override
	public String toString() {
		String s = "( Cercle de centre : " + p + " et de rayon : " + rayon +" Surface : "+this.surface()+")\n";
		return s;
	}
	
	public void translateC(int dx, int dy){
		this.p.translate(dx, dy);
	}
	
	public Point getP() {
		return p;
	}
	
	public double surface(){	
		return this.rayon * this.rayon * Math.PI;
	}
	
	public static void main(String[] args) {
		/*Point p=new Point(1,2);
		Circle c=new Circle(p,1);
		Circle c2=new Circle(p,2);
		c2.translate(1,1);
		System.out.println(c+" "+c2);*/
		
		Circle c=new Circle(new Point(1,2), 1);
		Circle c2 = new Circle(new Point(1,2),1);
		c.translateC(1,1);
		System.out.println(c);
		System.out.println(c2);
		
	}
}