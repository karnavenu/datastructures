package com.datastructures.map;

public class HashMapTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMapImpl hashMap = new HashMapImpl();
		hashMap.put("venu", 1);
		hashMap.put("ffxsdsdsdsdsdddsdf", 2);
		
		System.out.println(hashMap.get("venu"));
	}
}
