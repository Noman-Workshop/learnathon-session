package org.noman5237;

class Vault {
	int n;
	
	boolean valueSet = false;
	
	synchronized public int getN() {
		while (!valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("Got: " + n);
		valueSet = false;
		notify();
		return n;
	}
	
	synchronized public void setN(int n) {
		while (valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		this.n = n;
		valueSet = true;
		System.out.println("Set: " + n);
		notify();
	}
}


class Producer implements Runnable {
	Vault i;
	
	Producer(Vault i) {
		this.i = i;
		new Thread(this, "Producer").start();
	}
	
	@Override
	public void run() {
		var onnoI = 0;
		while (true) {
			i.setN(onnoI++);
//			i.setN(i.getN() + 1); // deadlock example
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}


class Consumer implements Runnable {
	Vault i;
	
	Consumer(Vault i) {
		this.i = i;
		new Thread(this, "Consumer").start();
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println("Consuming: " + i.getN());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
public class Queue {
	// task 1 -> generate numbers indefinitely
	// task 2 -> process the numbers in the queue indefinitely
	
	
	
	public static void main(String[] args) {
		
		Vault i = new Vault();
		new Producer(i);
		new Consumer(i);
	}
}
