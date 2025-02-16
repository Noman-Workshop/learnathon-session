package org.noman5237;

public class ThreadDemo {
//	sleep, currentThread, join, priority, stop, start
	static Integer i = 0;
	
	public static void main(String[] args) {
		Runnable task = () -> {
				System.out.println("Thread started" + Thread.currentThread().getName());
				for (; i < 5; ) {
					try {
						Thread.sleep(1000);
							System.out.printf("%s: %d\n",
							                  Thread.currentThread()
							                        .getName(),
							                  i++);
//					System.out.println(Thread.currentThread().getName() + ": " + i++);
					} catch (InterruptedException e) {
						System.out.println("Interrupted");
						throw new RuntimeException(e);
					}
			}
		};
		
		Thread thread = new Thread(task, "Thread 1");
		Thread thread1 = new Thread(task, "Thread 2");
		Thread thread2 = new Thread(task, "Thread 3");
		Thread thread3 = new Thread(task, "Thread 4");
		thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		
		System.out.println("Main thread started");
		
		try {
			thread.join();
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("Main thread exit");
	}
}
