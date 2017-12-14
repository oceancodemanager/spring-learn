package com.ocean.learn.spring.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class ListProxy<T> implements InvocationHandler {

	List<T> targetList;

	// public ListProxy() {
	// }

	public ListProxy(List<T> targetList) {
		this.targetList = targetList;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object ret = null;
		System.out.println("进入proxy:" + " method:" + method.getName());
		if (args != null) {
			for (Object o : args) {
				System.out.println("o:" + o);
			}
		}
		ret = method.invoke(targetList, args);
		System.out.println("执行结果ret：" + ret);
		System.out.println("=============================");
		return ret;
	}

}
