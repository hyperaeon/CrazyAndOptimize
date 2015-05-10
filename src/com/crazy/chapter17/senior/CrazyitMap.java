package com.crazy.chapter17.senior;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CrazyitMap<K, V> extends HashMap<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void removeByValue(Object value) {
		for (Object key : keySet()) {
			if (value == get(key)) {
				remove(key);
				break;
			}
		}
	}

	public Set<V> valueSet() {
		Set<V> result = new HashSet<V>();
		for (K key : keySet()) {
			result.add(get(key));
		}
		return result;
	}

	public K getKeyByValue(V value) {
		for (K key : keySet()) {
			if (value == get(key) && get(key).equals(value)) {
				return key;
			}
		}
		return null;
	}

	public V put(K key, V value) {
		for (V val : valueSet()) {
			if (val.equals(value) && val.hashCode() == value.hashCode()) {
				throw new RuntimeException("MyMap实例中不允许有重复value!");
			}
		}
		return super.put(key, value);
	}
}
