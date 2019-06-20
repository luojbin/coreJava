package com.loyofo.core.s14_concurrent.e0_oldDemo.day10_Thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreadSafeDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		System.out.println(list.getClass().getName()+list);
		list = Collections.synchronizedList(list);
		System.out.println(list.getClass().getName()+list);
		
		Set<String> set = new HashSet<String>(list);
		System.out.println(set.getClass().getName()+set);
		set = Collections.synchronizedSet(set);
		System.out.println(set.getClass().getName()+set);
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("语文", 89);
		map.put("数学", 92);
		map.put("英语", 90);
		map.put("物理", 99);
		map.put("化学", 99);
		System.out.println(map.getClass().getName()+map);
		map = Collections.synchronizedMap(map);
		System.out.println(map.getClass().getName()+map);
		
		/*
		 * 集合的元素操作方法，不与迭代器互斥
		 * 所以若多线程操作是，并发迭代与增删元素间不同步
		 * 可能会导致迭代出错，所以要自行维护互斥关系
		 */
		synchronized(map){
			Iterator<String> iter = map.keySet().iterator();
			while(iter.hasNext()){
				
			}
		}

	}

}
