package com.ocean.learn.spring.test.thread;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;

public class TestConcurrentLinkedQueue2 {

	private static Queue<String> workList = new ConcurrentLinkedDeque<String>();

	public static void main(String[] args) {

		// ExecutorService producerExcutors = Executors.newFixedThreadPool(2);
		// ExecutorService custumerExcutors = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10000; i++) {
			// producerExcutors.submit(new ProducerThread());
			workList.offer(UUID.randomUUID().toString());
		}
		Thread t1 = new Thread(new ConsumerThread());
		Thread t2 = new Thread(new ConsumerThread());
		Thread t3 = new Thread(new ConsumerThread());
		Thread t4 = new Thread(new ConsumerThread());

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		// custumerExcutors.submit(new ConsumerThread());
	}

	static class ProducerThread implements Runnable {

		@Override
		public void run() {
			workList.offer(UUID.randomUUID().toString());
		}
	}

	static class ConsumerThread implements Runnable {

		@Override
		public void run() {

			boolean empty1 = workList.isEmpty();
			System.out.println("ConsumerThread:" + Thread.currentThread().getName());
			while (!empty1) {
				boolean empty = workList.isEmpty();
				if (empty) {
					System.out.println("======================================!!!");
				}
				System.out.println("aaa:" + workList.remove());
			}
		}
	}

}
