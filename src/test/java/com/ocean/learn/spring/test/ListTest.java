package com.ocean.learn.spring.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 小总结： <br/>
 * ArrayList:
 * get(i)为O(1),remove(i)为O(n)（数组的下标需要变化）,Iterator的remove为O(n)因为这这个remove调用
 * ArrayList.this.remove(lastRet);<br>
 * LinkedList:get(i)为O(n),remove(i)为O(n),Iterator的remove为O(1)因为迭代器就在附近不用找位置
 * 
 * @author ocean
 *
 */
public class ListTest {
	private static List<Integer> hightestList = new ArrayList<Integer>(100);

	public static void forTest() {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < 10000000; i++) {
			arrayList.add(i);
		}
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < arrayList.size(); i++) {
			int ii = arrayList.get(i);
		}
		long beginTime2 = System.currentTimeMillis();
		System.out.println(arrayList.getClass() + "用时simple：" + (beginTime2 - beginTime));
		for (Integer i : arrayList) {
			int ii = i;
		}
		System.out.println(arrayList.getClass() + "用时z：" + (System.currentTimeMillis() - beginTime2));
		System.out.println("==================================================================");
	}

	public static void main(String[] args) {
		forTest();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < 1000000; i++) {
			linkedList.add(i);
		}

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < 1000000; i++) {
			arrayList.add(i);
		}

		removeOdd(linkedList);
		System.out.println(linkedList.size());
		// removeOdd2(arrayList);
		System.out.println(arrayList.size());

		List<Integer> list1 = hightestList;
		list1.add(1);
		list1.add(2);
		list1.add(3);
		System.out.println("t1:" + list1.size());
		System.out.println("t2:" + hightestList.size());
		List<Integer> list2 = hightestList;
		System.out.println("t3:" + list2.size());
		// list1 = Lists.newArrayListWithCapacity(initialArraySize)
		// System.out.println("ssssssss" + (list1 == list2));
		List<Integer> list13 = new ArrayList<Integer>(100);
		System.out.println("lll:" + list13.toArray().length);
		list13.add(1);
		list13.add(2);
		list13.add(3);
		list13.clear();
		System.out.println("ddd:" + list13.size());
		list13.add(6);
		System.out.println("lll:" + list13.toArray().length);
	}

	/**
	 * class java.util.ArrayList用时：1387902<br>
	 * 效率非常低
	 * 
	 * @param list
	 */
	public static void removeOdd2(List<Integer> list) {
		int size = list.size();
		long beginTime = System.currentTimeMillis();
		List<Integer> removeList = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			Integer a = list.get(i);
			if (a % 2 == 1) {
				removeList.add(a);
			}
		}
		list.removeAll(removeList);
		System.out.println(list.getClass() + "用时：" + (System.currentTimeMillis() - beginTime));
	}

	/**
	 * 对于LinkedList很快
	 * 
	 * @param list
	 */
	public static void removeOdd(List<Integer> list) {
		long beginTime = System.currentTimeMillis();
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			if (it.next() % 2 == 1) {
				it.remove();
			}
		}
		System.out.println(list.getClass() + "用时：" + (System.currentTimeMillis() - beginTime));
	}

}
