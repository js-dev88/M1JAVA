package TD7;

import java.util.Objects;

public class MyFIFO {

	private final Object[] array;
	private int head; // le premier �l�ment pouvant �tre enlev�
	private int tail; // la premi�re case vide
	

	public MyFIFO(int max) {
		if (max <= 0) {
			throw new IllegalArgumentException("No negative values");
		} else {
			array = new Object[max];
		}
	}

	public void offer(Object o) {
		if (head == tail && array[tail] != null) { // full
			throw new IllegalStateException("La liste est full");
		} else {
			array[tail++] = Objects.requireNonNull(o);
			if (tail == array.length) {
				tail = 0;
			}
		}

	}

	public Object poll() {
		if (head == tail && array[head] == null) { // empty
			throw new IllegalStateException("Poll sur une liste vide");
		}
		Object sav = array[head];
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
	//on veut une liste qui part de head jusqu'� tail (au mieux ils sont confondus) exemple avec tableau de longueur 4
	public String toString() {
		String rez = "[";
		if (this.isEmpty()){//cas liste vide
			rez += ", ";
		}else if(tail != head && this.size() != array.length){// cas liste partiellement remplie ( 2 premi�res cases sur 42)
			for(int k = 0; k < this.size(); k++){
				rez += array[k] + ", ";
			}
		}else{
				int j = 0; // on veut 3 it�rations apr�s le head pour arriver au tail 
				for (int i = head; i < array.length + head; i++) { //traitement valable quelque soit la position du head, au pire il est � la fin d'o� array.length + head
						j++; // compteur des it�rations (on en veut 4)
						if( i < array.length){ //cas simple on it�re sur des �l�ments de la liste
								if (array[i] == null) rez += "null, ";// si liste comporte un null (tail > head ou head > tail)
								else rez += array[i].toString() + ", ";// si liste pleine et tail = head
						}else{//cas o� on sort de la liste car head n'est pas en position 0 => on fait la m�me chose qu'en haut en soustraiant la longueur du tableau
								if (array[i - array.length] == null) rez += "null, ";
								else rez += array[i - array.length].toString() + ", ";
						}
				    if(j == array.length +1) //on s'arrache d�s qu'on a 4 �l�ments
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
		MyFIFO mf = new MyFIFO(42);
		mf.offer("ti");
		mf.offer("mon");
		System.out.println(mf.toString());
	}
}


