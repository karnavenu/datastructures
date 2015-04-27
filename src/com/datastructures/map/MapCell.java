package com.datastructures.map;

public class MapCell<K,V> {

	K key;
	V value;
	
	public MapCell(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}	
	
	public boolean equivalent(MapCell<K,V> c){		
		return key.equals(c.getKey());		
	}
	
	public boolean equivalent(K k){		
		return key.equals(k);		
	}
	
}
