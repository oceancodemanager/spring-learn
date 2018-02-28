package com.ocean.learn.spring.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor3 {
	private static final ExecutorService executorService = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("ssssssssssssss");
			}
		});
		executorService.shutdown();
	}
}
