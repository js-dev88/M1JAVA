package TD7;

import java.util.Objects;

public class MyFIFO {
	/*private int max;
	private Object[] tab;
	private int firstElemCursor;
	private int cursor;
	
	public MyFIFO(int max) {
		if(max <= 0) {
			throw new IllegalArgumentException("No negative values");
		}
		this.max = max;
		this.tab = new Object[this.max];
		this.firstElemCursor = 0;
		this.cursor= 0;
	}
	
	
	
	public void offer(Object obj) {
		if(Objects.isNull(obj)) {
			throw new IllegalArgumentException("Object must not be nul");
		}
		if(cursor < this.max ){
			tab[cursor] = obj;
			cursor++;
		}else {
			tab[firstElemCursor] = obj;
			firstEl emCursor ++;
			if(firstElemCursor == this.max){
				firstElemCursor = 0;
			}
		}
		
		
		
	}*/
	
	private final Object[] array;
	private int head;
	private int tail;
	
	public MyFIFO(int max) {
		if(max <= 0) {
			throw new IllegalArgumentException("No negative values");
		}else {
			array = new Object[max];
		}
			
	}
	public void offer(Object o) {
		if(head == tail && array[tail] != null) {
			array[head++] = Objects.requireNonNull(o);
			tail ++;
		}else {
			array[tail++] = Objects.requireNonNull(o);
			if(tail == array.length) {
				tail = 0;
			}
		}
		
	}
	
	public Object poll() {
		if(head == tail && array[head] == null) {
			return null;
		}
		Object sav = array[head];
		array[head++] = null;
		if(head == array.length) {
			head =0;
		}
		return sav;
	}
	
	public Object[] getTab() {
		return this.array;	
	}
	
	public static void main(String[] args) {
		MyFIFO mf = new MyFIFO(4);
		mf.offer("S1");
		mf.offer("S2");
		mf.offer("S3");
		mf.offer("S4");
		mf.offer("S5");
		mf.offer("S6");
		mf.offer("S7");
		mf.offer("S8");
		
		Object[] tableau = mf.getTab();
		for(int i =0; i< 4; i++) {
			System.out.println(tableau[i] + ";");
		};
	}
}
