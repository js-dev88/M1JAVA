package TD3;

public class GenericMyList<T> {

	private GenericCell<?> first;
	private GenericCell<?> switchCell;

	public GenericMyList() {
		this.first = null;
		this.switchCell = null;
	}
	public void setFirst(GenericCell<?> first) {
		this.first = first;
	}
	public GenericCell<?> getFirst() {
		return first;
	}

	public void add(Object object) {
		
		if (this.first != null) {
			this.setFirst(new GenericCell<Object>(object, this.first)); 
		} else {
			this.setFirst(new GenericCell<Object>(object, null));
		}
		
		
		
	}
	
	public void add(Object string, int i) throws IndexOutOfBoundsException{
		if( i > this.size()){
			throw new IndexOutOfBoundsException();
		}
		int j = 1;
		this.switchCell = this.getFirst();
		while(j<i){
			j++;
			this.switchCell = this.switchCell.getRef();
		}
		
        GenericCell<?> newCell = new GenericCell<Object>(string,this.switchCell.getRef());
		this.switchCell.setRef(newCell);
		
	}
	
	public int size(){
		int size = 0;
		this.switchCell = this.getFirst();
		if(this.switchCell != null){
			size++;
			while(this.switchCell.getRef() != null){
				size ++;
				this.switchCell = this.switchCell.getRef();
			}
		}else{
				return size;
		}
		return size;
	}

	@Override
	public String toString() {
		String s ="";
		this.switchCell = this.getFirst();
		while(this.switchCell.getRef() != null){
			s += this.switchCell.getVal()+" => ";
			this.switchCell = this.switchCell.getRef();
		}
		s += this.switchCell.getVal()+".";
		return s;
	}
	
	public void addLast(Object string){
		if(this.first != null){
			this.switchCell = this.getFirst();
			while(true){
				if(this.switchCell.getRef() != null){
					this.switchCell = this.switchCell.getRef();
				}else{
					break;
				}	
			}
			
			this.switchCell.setRef(new GenericCell<Object>(string));
		}else{
			this.add(string);
		}	
	}
	
	public Object get(int index){
		if( index > this.size() || index <= 0){
			throw new IndexOutOfBoundsException();
		}
		int j = 1;
		this.switchCell = this.getFirst();
		while(j<index){
			j++;
			this.switchCell = this.switchCell.getRef();
		}
		
		return this.switchCell.getVal();
	}
	
	public int sumLetters(){
		int sum = 0;
		String str;
		this.switchCell = this.getFirst();
		while(true){
			 
			 str = this.switchCell.getVal().toString();
			 char[] ch = str.toCharArray();
			 for(char c: ch){
				 sum += (int)c;
			 }
			
			this.switchCell = this.switchCell.getRef();
			if(this.switchCell.getRef() == null){
				break;
			}
		}
		return sum;
	}
	
	public boolean contains (Object obj){
		boolean bool = false;
		this.switchCell = this.getFirst();
		while(true){
			 
			 Object other = this.switchCell.getVal();
			 if(other == obj){
				 bool = true;
				 break;
			 }
			
			this.switchCell = this.switchCell.getRef();
			if(this.switchCell.getRef() == null){
				break;
			}
		}
		return bool;
	}
	public static void main(String[] args) {
		GenericMyList<String> ml = new GenericMyList<String>();
		ml.addLast("tatu");
		System.out.println(ml);
		ml.add("totu");
		System.out.println(ml);
		ml.add("tato");
		System.out.println(ml);
	    ml.add("toto");
		System.out.println(ml);
		ml.add("titi");
		System.out.println(ml);
		ml.add("test");
		System.out.println(ml);
		ml.addLast("tutu");
		System.out.println(ml);
		ml.add("tata",2);
		//ml.add(2);
		System.out.println(ml);
		System.out.println(ml.size());
		System.out.println(ml.get(4));
		System.out.println(ml.sumLetters());
		System.out.println(ml.contains("tato"));
	}
}
