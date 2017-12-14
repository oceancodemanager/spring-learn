package com.ocean.learn.spring.test.pattern.adepter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) {
		/*
		 * 
		 * InputStreamReader的父类是Reader
		 * InputStreamReader就是适配器，将Reader和传进来的InputStream两个类型适配起来
		 * 用法：InputStreamReader继承了Reader，持有了InputStream引用，Reader是目标接口，
		 * InputStream是源角色
		 */
		InputStreamReader inputStreamReader = new InputStreamReader(new InputStream() {

			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		});
	}
}
