package com.ocean.learn.spring.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * 测试两件事<br>
 * 1 关于ExecutorService<br>
 * 如果循环执行loop_size个线程，
 * 那么如果loop_size<max_thread_size,就会创建loop_size个线程，每一个线程执行execute之后就处于等待状态，<br>
 * 如果loop_size> max_thread_size,就会创建max_thread_size个线程<br>
 * <br>
 * 2 volatile 关键字含义 volatile不能保证原子性，例如a++，并不能++操作
 * 
 * @author ocean
 */
public class Executor2 {
	public static volatile int a = 0;
	private static final int max_thread_size = 20;
	private static final ExecutorService executorService = Executors.newFixedThreadPool(max_thread_size);
	private static final int loop_size = 500000;

	public static void main(String[] args) {
		for (int i = 0; i < loop_size; i++) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					synchronized (Executor2.class) {
						Executor2.a++;
					}
				}
			});
		}
		executorService.shutdown();
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (executorService.isTerminated()) {
				System.out.println("a:" + a);
				break;
			}
		}
	}
}
