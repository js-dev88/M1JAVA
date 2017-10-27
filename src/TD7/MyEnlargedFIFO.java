package TD7;

import java.util.Arrays;
import java.util.Objects;

public class MyEnlargedFIFO<E> {
	private  E[]  array;
	private int head; // = 0 le premier �l�ment pouvant �tre enlev�
	private int tail; // = 0 la premi�re case vide
	

	@SuppressWarnings("unchecked")
	public MyEnlargedFIFO(int max) {
		if (max <= 0) {
			throw new IllegalArgumentException("No negative values");
		} else {
			array =  (E[]) new Object[max];
		}
	}

	@SuppressWarnings("unchecked")
	public  void offer (E o) {
		if (tail == array.length - 1 ) {
			E[] doubledArray  =  (E[]) new Object[array.length * 2];
			System.arraycopy(array,0, doubledArray, 0, array.length);
			this.array = doubledArray;
		} else {
			array[tail++] = (E) Objects.requireNonNull(o);
			if (tail == array.length) {
				tail = 0;
			}
		}

	}

	public E poll() {
		if (head == tail && array[head] == null) { // empty
			throw new IllegalStateException("Poll sur une liste vide");
		}
		E sav = array[head];
		array[head++] = null; // on efface le GC
		if (head == array.length) { // circulaire
			head = 0;
		}
		return sav;
	}

	public boolean isEmpty() {
		return (head == tail && array[head] == null);
	}

	public int size() {

		int size = 0;
		for (int i = 0; i < this.array.length; i++) {
			if (array[i] != null) {
				size++;
			}
		}
		;
		return size;
	}

	@Override
	public String toString() {
		String rez = "[";
		if (this.isEmpty()){//cas liste vide
			rez += ", ";
		}else if(tail != head && this.size() != array.length){
			for(int k = 0; k < this.size(); k++){
				rez += array[k] + ", ";
			}
		}else{
			int j = 0; 
				for (int i = head; i < array.length + head; i++) { 
						if( i < array.length){ 
								if (array[i] == null) rez += "null, ";
								else rez += array[i].toString() + ", ";
						}else{
								if (array[i - array.length] == null) rez += "null, ";
								else rez += array[i - array.length].toString() + ", ";
						}
				    if(j == array.length +1) 
				    	break;
				}	
		}
		int lastComma;
		if((lastComma = rez.lastIndexOf(", ")) != -1){
			rez = rez.substring(0,lastComma);
		};
		
		return rez += "]";
	}

	public Object[] getTab() {
		return this.array;
	}

	public static void main(String[] args) {
		MyEnlargedFIFO<String> f = new MyEnlargedFIFO<>(3);
		f.offer("a");
		f.offer("b");
		f.poll();
		f.offer("c");
		//f.poll();
		f.offer("d");
		f.offer("e");
		f.offer("f");
		System.out.println(f);
		System.out.println(Arrays.toString(f.array));
	}
}
