package TD12;

import java.util.ArrayDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FIFO<E> {
	private ArrayDeque<E> file;
	private int maxSize;
	private final Object monitor = new Object() ;
	private final Lock lock = new ReentrantLock();
	
	
	public ArrayDeque<E> getFile() {
		return file;
	}
	
	public FIFO(int maxSize) {
		this.file = new ArrayDeque<>(maxSize);
		this.maxSize = maxSize;
	}
	
	public void add(E element) {
		synchronized(monitor) {
			if(this.countElement() != maxSize) {
				
					this.file.add(element);
				
				if(this.countElement() == 1) {
					this.monitor.notifyAll();
				}
			}else{
				try {
					this.monitor.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}	
		}
	}
	
	public void remove() {
		synchronized(monitor) {
			if(this.countElement() == maxSize) {
				
					this.file.poll();
				
				this.monitor.notifyAll();
			}else if(this.countElement() == 0){
				try {
					this.monitor.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				synchronized(monitor) {
					this.file.poll();
				}
			}
		}
	}
	
	public int countElement() {
		this.lock.lock();
		try {
			int i =0;
			for(E element : this.file) {
				if(element != null) {
					i++;
				}
			}
			return i;
		}finally {
			this.lock.unlock();
		}
	}
	//question 3 la verif doit être synchronized si la méthode est à part le résultat peut être modifié par un autre thread entre temps.
	
}
