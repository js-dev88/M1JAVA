package TD3;

public class Cell {
	private String val;
	private Cell ref;
	
	public Cell(String val, Cell ref) {
		this.val = val;
		this.ref = ref;
		
	}
	public Cell getRef() {
		return ref;
	}
	@Override
	public String toString() {
		
		return val.toString();
	}
}
