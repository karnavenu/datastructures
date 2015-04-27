package com.datastructures.map;

import java.util.LinkedList;

public class HashMapImpl<K, V> {

	private final int MAX_SIZE = 10;
	LinkedList<MapCell<K, V>>[] items;

	public HashMapImpl(){
		items = (LinkedList<MapCell<K, V>>[])new LinkedList[MAX_SIZE];
	}
	public void put(K key, V value) {
		int hashCodeofKey = hashCodeOfKey(key);
		if (items[hashCodeofKey] == null) {
			items[hashCodeofKey] = new LinkedList<MapCell<K, V>>();
		}

		LinkedList<MapCell<K, V>> collided = items[hashCodeofKey];
		for (MapCell<K, V> c : collided) {
			if (c.equivalent(key)) {
				collided.remove(c);
			}
		}

		MapCell<K, V> cell = new MapCell<K, V>(key, value);
		collided.add(cell);
	}

	public V get(K key) {
		int hashCodeofKey = hashCodeOfKey(key);
		LinkedList<MapCell<K, V>> collided = items[hashCodeofKey];
		if(collided!=null){
			for (MapCell<K, V> c : collided) {
				if (c.equivalent(key)) {
					return c.getValue();
				}
			}
		}
		return null;
	}

	public int hashCodeOfKey(K key) {
		return key.toString().length() % items.length;
	}
}
