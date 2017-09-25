package TD1;

public class Circle {
	private Point center;
	private double rayon;

	public Circle(Point p, double rayon) {
		this.center = new Point(p);
		this.rayon = rayon;
	}

	@Override
	public String toString() {
		String s = "( Cercle de centre : " + center + " et de rayon : " + rayon + " Surface : " + this.surface()
				+ ")\n";
		return s;
	}

	public void translateC(int dx, int dy) {
		this.center.translate(dx, dy);
	}

	public Point getCenter() {
		return center;
	}

	public double surface() {
		return this.rayon * this.rayon * Math.PI;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Circle))
			return false;
		Circle other = (Circle) obj;
		if (this.center == other.center && this.rayon == other.rayon) {
			return true;
		} else {
			return false;
		}
	}

	public boolean contains(Point p) {
		if (Math.sqrt(Math.pow(this.center.getX() - p.getX(), 2)
				+ Math.pow(this.center.getY() - p.getY(), 2)) <= this.rayon) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean contains(Point p, Circle... circles) {
		for (Circle c : circles) {
			if (Math.sqrt(
					Math.pow(c.center.getX() - p.getX(), 2) + Math.pow(c.center.getY() - p.getY(), 2)) <= c.rayon) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		/*
		 * Point p=new Point(1,2); Circle c=new Circle(p,1); Circle c2=new
		 * Circle(p,2); c2.translate(1,1); System.out.println(c+" "+c2);
		 */

		Circle c = new Circle(new Point(0, 0), 2);
		Circle c2 = new Circle(new Point(0, 0), 3);
		//c.translateC(1, 1);
		System.out.println(c.contains(new Point(1,1)));
		System.out.println(c2);
		System.out.println(Circle.contains(new Point(1,1), c,c2));
	}


}