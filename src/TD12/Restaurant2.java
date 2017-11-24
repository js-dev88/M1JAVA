package TD12;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Restaurant2 {
	private FIFO<Cake>cakeFile;
	private final Object monitor = new Object() ;
	
	public Restaurant2(int maxSize){
		this.cakeFile= new FIFO<Cake>(maxSize);
	}
	
	public ArrayDeque<Cake> getFile() {
		return cakeFile.getFile();
	}
	
	public Runnable createAddCake (String type, int tps) {
		return new Runnable() {
			@Override public void run() {
				int i =1;
				while(true) {
						cakeFile.add(new Cake("cheeseCake"+i++));
					try {
						Thread.sleep(tps);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Create :" + type + i +" file : "+cakeFile.countElement());

				}
				
		    }
		};
	}
	
	public Runnable eatCake (String nomMangeur, int tps) {
		return new Runnable() {
			@Override public void run() {
				while(true) {

					cakeFile.remove();
					try {
						Thread.sleep(tps);
					} catch (InterruptedException e) {
								e.printStackTrace();
					}
					System.out.println(nomMangeur+ " Eat "+" file : "+cakeFile.countElement() );

				}
				
		    }
		};
	}
	
	public static void main(String[] args) {
		Restaurant2 resto = new Restaurant2(10);
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
