package csi213;

import java.util.LinkedList;

public class EnglishToSpanishTranslator {
    private int size; //size of the table
    private LinkedList<Entry>[] table; //an array of LinkedList
    
    // Entry class to hold key-value pairs
    private class Entry {
        String key;
        String value;
        
        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    
    // Constructor to initialize the hash table with a given size
    public EnglishToSpanishTranslator(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<Entry>();
        }
    }
    
    // Hash function to map a key to an index in the table
    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 31 + key.charAt(i)) % size;
        }
        return hash;
    }
    
    // Method to put a key-value pair into the table
    public void put(String key, String value) {
        int index = hash(key);
        LinkedList<Entry> list = table[index];
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        list.add(new Entry(key, value));
    }
    
    // Method to get the value associated with a given key
    public String get(String key) {
        int index = hash(key);
        LinkedList<Entry> list = table[index];
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
    	EnglishToSpanishTranslator dictionary = new EnglishToSpanishTranslator(100);
        dictionary.put("hello", "hola");
        dictionary.put("world", "mundo");
        dictionary.put("cat", "gato");
        dictionary.put("dog", "perro");
        
        String spanishWord = dictionary.get("hello");  // "gato"
        System.out.println(spanishWord);
    }
}



