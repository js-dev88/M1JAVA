package TD11;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyIterator {
	private static ArrayList<Integer> list = new ArrayList<>();
	private final static Lock lock = new ReentrantLock();
	
	public Runnable myMethode (int para) {
		return new Runnable() {
			@Override public void run() {
				int i =0;
				for(i =0;i < 50000; i++) {
					/*synchronized(list){
						list.add(i);
					}*/
					lock.lock();
					try{
						list.add(i);
					}finally {
						lock.unlock();
					}
					System.out.println("Thread - "+para+" "+ i);
				}
				
		    }
		};
	}
	
	//probleme add pas atomique => ctrl + clic check code de add Arraylist pas thread safe => AofBound exception et valeurs différentes
	
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Thread> lt = new ArrayList<>();
		Scanner m = new Scanner(System.in);
		/*System.out.println("Saisir un nombre");
		int nb = m.nextInt();*/
		
		for(int i = 0; i < 4; i++) {
			lt.add(new Thread(new MyIterator().myMethode(i)));
			lt.get(i).start();
		}
		for(int i = 0; i < 4; i++) {
			lt.get(i).join();
		}
		System.out.println("J'ai tout fini");
		System.out.println(MyIterator.list.size());
		int nb2 = 0;
		/*for(int j = 0; j< nb; j++) {
			Scanner m2 = new Scanner(System.in);
			System.out.println("Saisir un id de thread :");
			nb2 = m2.nextInt();
			lt.get(nb2).interrupt();
		}*/
	}
		
		
}
