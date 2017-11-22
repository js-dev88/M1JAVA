package TD11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//pas thread safe car retrait / depotn'est pas atomique donc on peut d'interro:pre en cours de traitement
public class Account {
	private int val;
	private String oper;
	//private final Object monitor = new Object() ;
	private final Lock lock = new ReentrantLock();// permet d'avoir des opérations supplémentaires
	
	
	public static void main(String[] args) {
		final Account acc = new Account();
		Thread retrait = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5000; ++i) {
					//synchronized(acc.monitor) {
						acc.lock.lock();
						try {
							acc.oper = "retrait";
							acc.val = 50;
							System.out.println(acc.oper + " " + acc.val + "euros");
						}finally {
							acc.lock.unlock();
						}					
					//}	
				}
			}
		});
		Thread depot = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5000; ++i) {
					//synchronized(acc.monitor) {
					acc.lock.lock();
					try {
						acc.oper = "depot";
						acc.val = 100;
						System.out.println(acc.oper + " " + acc.val + "euros");
					}finally {
						acc.lock.unlock();
					}
					
					
					//}
				}
			}
		});
		retrait.start();
		depot.start();
	}
}
