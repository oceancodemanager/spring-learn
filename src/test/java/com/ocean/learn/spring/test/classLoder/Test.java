package com.ocean.learn.spring.test.classLoder;

import java.lang.reflect.Method;

public class Test {

	public static void main1(String[] args) {
		InitValueEntity a;
		try {
			a = (InitValueEntity) Class.forName("com.ocean.learn.spring.test.classLoder.InitValueEntity").newInstance();
			a.increase();
			System.out.println("a：" + a.INIT_VALUE);
		} catch (Exception e) {
		}
		InitValueEntity b;
		try {
			b = (InitValueEntity) Class.forName("com.ocean.learn.spring.test.classLoder.InitValueEntity").newInstance();
			b.increase();
			System.out.println("a：" + b.INIT_VALUE);
		} catch (Exception e) {
		}
	}

	/**
	 * 2个类加载器，加载同一个类，成为不同的class，数据是各自的
	 * 
	 * @param args
	 */
	public static void main2(String[] args) {
		// Test.class.getClassLoader().getResource("").toString()
		MyClassLoader classLoader1 = new MyClassLoader(
				"D:/eclipse_workspace_2/spring-learn/target/test-classes/com/ocean/learn/spring/test/classLoder/");
		try {
			Class c = classLoader1.findClass("InitValueEntity.class");
			Object o1 = c.newInstance();
			System.out.println("d：" + o1.getClass().getClassLoader());
			Method m1 = c.getDeclaredMethod("increase");
			m1.setAccessible(true);
			m1.invoke(o1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 用第二个类加载器
		MyClassLoader2 classLoader2 = new MyClassLoader2(
				"D:/eclipse_workspace_2/spring-learn/target/test-classes/com/ocean/learn/spring/test/classLoder/");
		try {
			Class c = classLoader2.findClass("InitValueEntity.class");
			Object o1 = c.newInstance();
			System.out.println("d：" + o1.getClass().getClassLoader());
			Method m1 = c.getDeclaredMethod("increase");
			m1.setAccessible(true);
			m1.invoke(o1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * MyClassLoader3中className和class文件的名字不同，测试一下 报错
	 * java.lang.NoClassDefFoundError:
	 * com/ocean/learn/spring/test/classLoder/InitValue (wrong name:
	 * com/ocean/learn/spring/test/classLoder/InitValueEntity)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Test.class.getClassLoader().getResource("").toString()
		MyClassLoader3 classLoader3 = new MyClassLoader3(
				"D:/eclipse_workspace_2/spring-learn/target/test-classes/com/ocean/learn/spring/test/classLoder/");
		try {
			Class c = classLoader3.findClass("InitValueEntity.class");
			Object o1 = c.newInstance();
			System.out.println("d：" + o1.getClass().getClassLoader());
			Method m1 = c.getDeclaredMethod("increase");
			m1.setAccessible(true);
			m1.invoke(o1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 数组类的cloassloder为null 系统指定
	 * 
	 * @param args
	 */
	public static void main3(String[] args) {

		int[] intarray = new int[22];
		System.out.println("intarray.getClass().getClassLoader():" + intarray.getClass().getClassLoader());
		System.out.println("Class.getClassLoader()：" + Class.class.getClassLoader());
	}
}
