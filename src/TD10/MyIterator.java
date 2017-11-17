package TD10;

import java.util.ArrayList;
import java.util.Scanner;

public class MyIterator{
	
	
	public Runnable myMethode (int para) {
		return new Runnable() {
			@Override public void run() {
				int i=0 ;
				while(!Thread.interrupted()) {
					i++;
				}
				System.out.println("Thread - "+para+" "+ i);
		    }
		};
	}
	
	public static void main(String[] args) {
		ArrayList<Thread> lt = new ArrayList<>();
		Scanner m = new Scanner(System.in);
		System.out.println("Saisir un nombre");
		int nb = m.nextInt();
		
		for(int i = 0; i < nb; i++) {
			lt.add(new Thread(new MyIterator().myMethode(i)));
			lt.get(i).start();
		}
		int nb2 = 0;
		for(int j = 0; j< nb; j++) {
			Scanner m2 = new Scanner(System.in);
			System.out.println("Saisir un id de thread :");
			nb2 = m2.nextInt();
			lt.get(nb2).interrupt();
		}
		
		
		
		
		
		
		
		
		
	}

}
