package TD1;

public class Ring extends Circle {
	private double rayonInterne;

	public Ring(Point p, double rayon, double rayonInterne) throws IllegalArgumentException {
		super(p, rayon);
		if (rayon < rayonInterne) {
			throw new IllegalArgumentException("Le rayon interne doit être inférieur au rayon du cercle");
		}
		this.rayonInterne = rayonInterne;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Ring))
			return false;
		boolean bool = super.equals(obj);
		Ring other = (Ring) obj;
		if (bool && this.rayonInterne == other.rayonInterne) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Rayon interne :" + this.rayonInterne;
	}

	@Override
	public boolean contains(Point p) {
		if (super.contains(p)) {
			if (Math.sqrt(Math.pow(this.getCenter().getX() - p.getX(), 2)
					+ Math.pow(this.getCenter().getY() - p.getY(), 2)) <= this.rayonInterne) {
				return false;
			}

			return true;
		}
		return false;

	}

	public static boolean contains(Point p, Ring... rings) {
		for (Ring r : rings) {
			if (r.contains(p)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Ring ring = new Ring(new Point(0, 0), 3, 1);
		System.out.println(Ring.contains(new Point(2, 2), ring));
		System.out.println(ring);

	}

}
