package com.ocean.learn.spring.test.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockingQueueTest {
	public static void main(String[] args) {
		// SynchronousQueue
		SynchronousQueue<String> s = new SynchronousQueue<String>();
		// // s.add("");
		// try {
		// //线程阻塞了，除非其他线程取走里面的数据
		// s.put("sss");
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		System.out.println("s：" + s.size());
		//
		ArrayBlockingQueue<String> abQueue = new ArrayBlockingQueue<String>(2);
		abQueue.add("1");
		abQueue.add("2");
		try {
			abQueue.put("3");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// LinkedBlockingQueue
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
	}
}
