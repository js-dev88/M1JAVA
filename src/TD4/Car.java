package TD4;

public class Car {

	private final String brand;
	private final String licencePlate;
	private long value;
	private int vetust;

	public Car(String brand, String licencePlate, long value) {
		if (value < 0) {
			throw new IllegalArgumentException("Impossible de créer une voiture avec une valeur négative");
		}
		this.brand = brand;
		this.licencePlate = licencePlate;
		this.value = value;
	}

	public Car(String brand, String licencePlate, long value, int vetust) {
		this(brand, licencePlate, value);
		this.vetust = vetust;
		this.value -= (this.vetust * 1000);
	}

	public String getBrand() {
		return brand;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public long getValue() {
		return value;
	}
	
	public int getVetust() {
		return vetust;
	}

	@Override
	public String toString() {
		return "Brand : " + this.getBrand() + " LP : " + this.getLicencePlate() + " value : " + this.getValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((licencePlate == null) ? 0 : licencePlate.hashCode());
		result = prime * result + (int) (value ^ (value >>> 32));
		result = prime * result + vetust;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		//index of appel equals
		if(! (obj instanceof Car)) return false;
		Car other = (Car) obj;
		if(this.getBrand().equals(other.getBrand())
		&& this.getLicencePlate().equals(other.getLicencePlate())
		&& this.getValue() == other.getValue()
		&& this.getVetust() == other.getVetust()){
			return true;
		}else{
			return false;
		}
	}
	
	

	
	
	
	
	

}
