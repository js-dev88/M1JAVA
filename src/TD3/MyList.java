package TD3;

import java.util.ArrayList;

public class MyList {
	
	private Cell first;
	
	public MyList() {
		
	}
	
	public Cell getFirst() {
		return first;
	}
	
	public void add(String val){
		this.first = new Cell(val,null);
	}
	
	public int size(){
		int cpt = 1;
		if(this.getFirst().getRef() != null){
			
		}else{
			return cpt;
		}
		
	}
	
}

