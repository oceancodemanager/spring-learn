package com.ocean.learn.spring.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// @ContextConfiguration(locations = { "classpath:applicationContext.xml" })

public class BaseJunitTest {
	@Before
	public void before() {
		System.out.println("before");
	}

	@After
	public void after() {
		System.out.println("after");
	}

	@Test
	public void test3() {
		System.out.println("test3");
	}

	@Test
	public void test1() {
		System.out.println("test1");
	}

	@Test
	public void test2() {
		System.out.println("test2");
	}

}
