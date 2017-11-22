package TD11;

import java.util.concurrent.locks.ReentrantLock;

public class Diner {
	private final ReentrantLock[] forks;

	public Diner(int nbPlates) {
		forks = new ReentrantLock[nbPlates];
		for (int i = 0; i < nbPlates; ++i)
			forks[i] = new ReentrantLock();
	}

	public void eat(int guyIndex) {
		ReentrantLock forkLeft = forks[guyIndex];
		ReentrantLock forkRight = forks[(guyIndex + 1) % forks.length];
		boolean bool = false;
		int count = 0;
		
			while(!bool) {
				count++;
				forkLeft.lock();
				if(forkRight.tryLock()) {
					System.out.println("Guy " + guyIndex + " is eating.");
					forkLeft.unlock();	
					forkRight.unlock();
					bool = true;
				}else {
					forkLeft.unlock();			
				}
			}
			
	}

	public static void main(String[] args) {
		int nbGuys = 5;
		Diner d = new Diner(nbGuys);
		for (int i = 0; i < nbGuys; ++i) {
			final int guy = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					d.eat(guy);
				}
			}).start();
		}
	}
}
