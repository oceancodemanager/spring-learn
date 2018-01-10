package com.ocean.learn.spring.test;

import java.util.UUID;

public class StringTest {
	public static void main(String[] args) {
		// int i = 0;
		// i += 5;
		// i = intrease(i);
		// System.out.println("i=" + i);

		System.out.println("UUID .randomUUID().toString():" + UUID.randomUUID().toString());
	}

	// DelayQueue<Delayed>
	private static int intrease(int i) {
		i += 100;
		return i;
	}
}
