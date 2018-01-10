package com.ocean.learn.spring.test.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {
	public static volatile int a = 0;
	// 有趣的测试
	/**
	 * newSingleThreadExecutor的情况下，如果不发生错误就是一个线程在执行
	 */
	// private static final ExecutorService executorService =
	// Executors.newSingleThreadExecutor();
	private static final ExecutorService executorService = Executors.newFixedThreadPool(20);

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("thread_name:" + Thread.currentThread().getName());
					if (new Random().nextBoolean()) {
						// String a = null;
						// System.out.println(a.length());
					}
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// Executor.a++;
					// System.out.println("a" + Executor.a++);
				}
			});
		}
		System.out.println("here");
		// 由于Thread.sleep(10000),线程依然没有停止，可以导出线程看一下哪些还在工作

	}
}
