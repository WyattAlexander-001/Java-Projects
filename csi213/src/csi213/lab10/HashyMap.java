package csi213.lab10;

import java.util.LinkedList;

public class HashyMap<K extends Comparable<K>,V extends Comparable<V>>  {
    public class Entry {
        public Entry(K k, V v) {
            key = k;
            value = v;
        }
        public K key;
        public V value;
        
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    Object[] data; // an array of linked lists of Entries

    public HashyMap () { // use a default size of 11
    	this(11);
    }

    public HashyMap (int size) { // make data equal to size
        data = new Object[size];
        for (int i = 0; i < data.length; i++) {  // Iterate through the data array and initialize each element as a new LinkedList<Entry>
            data[i] = new LinkedList<Entry>();
        }
    }

    private int hash(K key) { // calculate the hash value using hashCode
    	 return (key.hashCode() & Integer.MAX_VALUE) % data.length; //// Compute the hash code of the key, bitwise AND with Integer.MAX_VALUE to remove the sign bit
    }

    @SuppressWarnings("unchecked")
    public int size() { // get the number of elements in the hash map
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            LinkedList<Entry> list = (LinkedList<Entry>) data[i];
            count += list.size();
        }
        return count;
    }

    @SuppressWarnings("unchecked")
    public boolean isEmpty() { // are there any entries in the hash map?
        return size() == 0;
    }

    public boolean containsKey(K key) { // does this key exist?
        int index = hash(key);
        LinkedList<Entry> list = (LinkedList<Entry>) data[index];
        return list.stream().anyMatch(e -> e.key.equals(key));
    }

    @SuppressWarnings("unchecked")
    public boolean containsValue(V value) { // does this value exist? This is SLOW.
        for (int i = 0; i < data.length; i++) {
            LinkedList<Entry> list = (LinkedList<Entry>) data[i];
            if (list.stream().anyMatch(e -> e.value.equals(value))) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public V get(K key) { // get the value for this key
        int index = hash(key);
        LinkedList<Entry> list = (LinkedList<Entry>) data[index];
        return list.stream()
                .filter(e -> e.key.equals(key))
                .map(e -> e.value)
                .findFirst()
                .orElse(null);
    }

    @SuppressWarnings("unchecked")
    public void put(K key, V value) { // create an entry and put it in the hashymap. Don't worry about duplicates
        int index = hash(key);
        Entry entry = new Entry(key, value);
        LinkedList<Entry> list = (LinkedList<Entry>) data[index];
        list.add(entry);    
    }

    @SuppressWarnings("unchecked")
    public V remove(K key) { // remove the entry matching this key
        int index = hash(key);
        LinkedList<Entry> list = (LinkedList<Entry>) data[index];
        Entry entry = list.stream()
                .filter(e -> e.key.equals(key))
                .findFirst()
                .orElse(null);

        if (entry != null) {
            list.remove(entry);
            return entry.value;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public void clear() { // empty the whole hashymap
        for (int i = 0; i < data.length; i++) {
            LinkedList<Entry> list = (LinkedList<Entry>) data[i];
            list.clear();
        }
    }

    @SuppressWarnings("unchecked")
    public LinkedList<K> keys() { // get all of the keys; make a new linked list
        LinkedList<K> keys = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            LinkedList<Entry> list = (LinkedList<Entry>) data[i];
            for (Entry entry : list) {
                keys.add(entry.key);
            }
        }
        return keys;
    }

    @SuppressWarnings("unchecked")
    public LinkedList<V> values() { // get all of the values; make a new linked list
    	LinkedList<V> values = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            LinkedList<Entry> list = (LinkedList<Entry>) data[i];
            for (Entry entry : list) {
                values.add(entry.value);
            }
        }
        return values;
    }

    @SuppressWarnings("unchecked")
    public LinkedList<Entry> entries() { // get all of the entries; make a new linked list
        LinkedList<Entry> entries = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            LinkedList<Entry> list = (LinkedList<Entry>) data[i];
            entries.addAll(list);  // Add all the entries from the current linked list to the main entries list
        }
        return entries;
    }
}