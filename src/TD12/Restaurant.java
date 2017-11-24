package TD12;

import java.util.ArrayDeque;
import java.util.ArrayList;


public class Restaurant {
	private ArrayDeque<Cake> file;
	private final Object monitor = new Object() ;
	
	public Restaurant() {
		this.file = new ArrayDeque<Cake>();
	}
	
	public ArrayDeque<Cake> getFile() {
		return file;
	}
	
	public Runnable createAddCake (String type, int tps) {
		return new Runnable() {
			@Override public void run() {
				while(true) {
					synchronized(monitor) {
						
						file.add(new Cake(type));
					}
					try {
						Thread.sleep(tps);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Create :" + type +" file : "+file.size());
					

				}
				
		    }
		};
	}
	
	public Runnable eatCake (String nomMangeur, int tps) {
		return new Runnable() {
			@Override public void run() {
				while(true) {
					
					synchronized(monitor) {
						file.poll();

					}
					try {
						Thread.sleep(tps);
					} catch (InterruptedException e) {
								e.printStackTrace();
					}
					System.out.println(nomMangeur+ " Eat "+" file : "+file.size() );

				}
				
		    }
		};
	}
	
	public static void main(String[] args) {
		Restaurant resto = new Restaurant();
		ArrayList<Thread> prod = new ArrayList<>();
		
		for(int i= 0 ; i< 1; i++) {
			prod.add(new Thread(resto.createAddCake("CheeseCake", 2000)));
			prod.get(i).start();
		}
		
		ArrayList<Thread> lt = new ArrayList<>();
		for(int i= 0 ; i< 5; i++) {
			lt.add(new Thread(resto.eatCake(String.valueOf(i), 2000)));
			lt.get(i).start();
		}
		
		
	
	}
}
