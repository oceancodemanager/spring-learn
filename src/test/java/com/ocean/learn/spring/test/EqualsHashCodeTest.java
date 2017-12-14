package com.ocean.learn.spring.test;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 对象的散列码是为了更好的支持基于哈希机制的Java集合类，例如 Hashtable, HashMap, HashSet 等。用于散列。 <br/>
 * 数值比较:在进行浮点数比较的时候，主要需要考虑3个因素
 * 
 * 1 NaN 2 无穷大/无穷小 3舍入误差<br/>
 * 数字比较总结：最好判断not NaN之后用BigDecimal
 * http://blog.csdn.net/wcxiaoych/article/details/42806313
 * 
 * @author ocean
 *
 */
public class EqualsHashCodeTest {
	public static void main(String[] args) {

		String a = "Aa";
		String b = "BB";
		int aa = a.hashCode();
		int bb = b.hashCode();
		System.out.println(aa);
		System.out.println(bb);
		// String a = "Aa";
		// String b = "BB";
		System.out.println(a.equals(b));

		HashMap<String, String> map = new HashMap<String, String>();
		map.put(a, "ss");
		map.put(b, "www");
		System.out.println("map:" + map.size());

		Double d1 = Double.valueOf("0.0");
		Double d2 = Double.valueOf("-0.0");
		System.out.println(d1.equals(d2));
		System.out.println("doubleToLongBits:" + (Double.doubleToLongBits(d1) == Double.doubleToLongBits(d2)));
		System.out.println("doubleToLongBits2:" + (Double.doubleToLongBits(0.0) == Double.doubleToLongBits(-0.0)));
		System.out.println("compare:" + (d1.compareTo(d2)));
		// NaN
		Double c1 = Math.sqrt(-1.0);
		Double c2 = 0.0d / 0.0d;
		Double c3 = c1 + 200.0d;
		Double c4 = c2 + 1.0d;
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c1.equals(c2));
		System.out.println(c2.equals(c3));
		System.out.println(c3.equals(c4));
		// BigDecimal
		BigDecimal b1 = BigDecimal.valueOf(d1);
		BigDecimal b2 = BigDecimal.valueOf(d2);
		System.out.println(b1.equals(b2));
		// NaN报错
		// System.out.println("BigDecimal：NaN:" + BigDecimal.valueOf(c1));
		Double g1 = 1.0 / 0.0;
		// 打印Infinity
		System.out.println("BigDecimal：无穷大:" + g1);
		float fPos = Float.POSITIVE_INFINITY;
		float fNeg = Float.NEGATIVE_INFINITY;
		double dPos = Double.POSITIVE_INFINITY;
		double dNeg = Double.NEGATIVE_INFINITY;
		// System.out.println(BigDecimal.valueOf(c1));

	}
}
