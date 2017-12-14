package com.ocean.learn.spring.test.classLoder;

public class InitValueEntity {
	public static int INIT_VALUE = 1;

	// static {
	// INIT_VALUE++;
	// }
	//
	void increase() {
		INIT_VALUE++;
		System.out.println(INIT_VALUE);
	}
}
