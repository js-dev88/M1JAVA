package TD4;

public class Car {

	private final String brand;
	private final String licencePlate;
	private final long value;

	public Car(String brand, String licencePlate, long value) {
		if( value < 0){
			throw new IllegalArgumentException("Impossible de créer une voiture avec une valeur négative");
		}
		this.brand = brand;
		this.licencePlate = licencePlate;
		this.value = value;
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
	
	@Override
	public String toString() {
		
		return "test";
	}
	
	

}
