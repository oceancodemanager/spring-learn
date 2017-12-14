package com.ocean.learn.spring.test.pattern.decorator;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;

/**
 * 装饰类装饰被装饰类的目的是赋予被装饰类更多的功能，同事不改变被装饰类
 * 
 * @author ocean
 *
 */
public class Test {
	public static void main(String[] args) {
		/*
		 * filterInputStream 持有被装饰的引用，实现被装饰接口
		 * 
		 */
		FilterInputStream filterInputStream;
		/*
		 * 装饰器的实现者
		 * 
		 */
		BufferedInputStream bufferedInputStream;
	}
}
