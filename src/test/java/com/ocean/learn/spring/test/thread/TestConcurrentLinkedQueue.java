package com.ocean.learn.spring.test.thread;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestConcurrentLinkedQueue {

	private static Queue<String> workList = new ConcurrentLinkedDeque<String>();

	public static void main(String[] args) {

		ExecutorService producerExcutors = Executors.newFixedThreadPool(2);
		ExecutorService custumerExcutors = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			producerExcutors.submit(new ProducerThread());
			custumerExcutors.submit(new ConsumerThread());
		}
	}

	static class ProducerThread implements Runnable {

		@Override
		public void run() {
			System.out.println("Prod");
			workList.offer(UUID.randomUUID().toString());
			System.out.println("ProducerThread:" + workList.isEmpty());
		}
	}

	static class ConsumerThread implements Runnable {

		@Override
		public void run() {
			boolean empty1 = workList.isEmpty();
			System.out.println("ConsumerThread:" + empty1);
			while (!empty1) {
				boolean empty = workList.isEmpty();
				if (empty) {
					System.out.println("======================================!!!");
				}
				System.out.println("aaa:" + workList.remove());
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
