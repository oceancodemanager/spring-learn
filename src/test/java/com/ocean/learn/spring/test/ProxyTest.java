package com.ocean.learn.spring.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class ProxyTest<T> implements InvocationHandler {
	List<T> target;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("进入proxy:" + " method:" + method.getName() + " args:" + args.toString());
		return null;
	}

}
