package com.ocean.learn.spring.test.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(20);
		Class targetClass = list.getClass();
		ListProxy<String> proxy = new ListProxy<String>(list);
		List<String> opList = (List<String>) Proxy.newProxyInstance(targetClass.getClassLoader(),
				targetClass.getInterfaces(), proxy);
		opList.add("aaaa");
		opList.add("bbbb");
		opList.add("cccc");
		opList.remove(0);
		opList.size();
		opList.get(0);
	}
}
