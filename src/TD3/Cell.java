package TD3;

public class Cell {
	private String val;
	private Cell ref;
	
	public Cell(String val){
		this.val = val;
		this.ref = null;
	}
	
	public Cell(String val, Cell ref) {
		this.val = val;
		this.ref = ref;
		
	}
	
	public Cell getRef() {
		return ref;
	}
	
	public void setRef(Cell ref) {
		this.ref = ref;
	}
	public String getVal() {
		return val;
	}
	

}
