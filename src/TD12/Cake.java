package TD12;

public class Cake {
	private String type;
	
	public Cake(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return type;
	}
	
	
}
