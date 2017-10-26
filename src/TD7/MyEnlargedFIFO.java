package TD7;

import java.util.Arrays;
import java.util.Objects;

public class MyEnlargedFIFO<E> {
	private  E[]  array;
	private int head; // = 0 le premier élément pouvant être enlevé
	private int tail; // = 0 la première case vide
	

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
	//on veut une liste qui part de head jusqu'à tail (au mieux ils sont confondus) exemple avec tableau de longueur 4
	public String toString() {
		String rez = "[";
		if (this.isEmpty()){//cas liste vide
			rez += ", ";
		}else if(tail != head && this.size() != array.length){// cas liste partiellement remplie ( 2 premières cases sur 42)
			for(int k = 0; k < this.size(); k++){
				rez += array[k] + ", ";
			}
		}else{
				int j = 0; // on veut 3 itérations après le head pour arriver au tail 
				for (int i = head; i < array.length + head; i++) { //traitement valable quelque soit la position du head, au pire il est à la fin d'où array.length + head
						j++; // compteur des itérations (on en veut 4)
						if( i < array.length){ //cas simple on itère sur des éléments de la liste
								if (array[i] == null) rez += "null, ";// si liste comporte un null (tail > head ou head > tail)
								else rez += array[i].toString() + ", ";// si liste pleine et tail = head
						}else{//cas où on sort de la liste car head n'est pas en position 0 => on fait la même chose qu'en haut en soustraiant la longueur du tableau
								if (array[i - array.length] == null) rez += "null, ";
								else rez += array[i - array.length].toString() + ", ";
						}
				    if(j == array.length +1) //on s'arrache dès qu'on a 4 éléments
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
