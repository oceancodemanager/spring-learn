package com.ocean.learn.spring.test.classLoder;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader2 extends ClassLoader {
	private String classPath;
	String className = "com.ocean.learn.spring.test.classLoder.InitValueEntity";

	public MyClassLoader2() {
	}

	public MyClassLoader2(String classPath) {
		this.classPath = classPath;
	}

	// com.ocean.learn.spring.test.classLoder
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getData(name);
		return defineClass(className, classData, 0, classData.length);
	}

	private byte[] getData(String className) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(classPath + className);
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int num = 0;
			while ((num = fis.read(buffer)) != -1) {
				stream.write(buffer, 0, num);
			}
			return stream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
