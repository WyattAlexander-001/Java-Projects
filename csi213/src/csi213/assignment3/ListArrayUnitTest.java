package csi213.assignment3;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class ListArrayUnitTest {

    @Test
    public void testGet() {
        ListArray<Integer> list = new ListArray<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        // Test getting elements from the list
        for (int i = 0; i < list.size(); i++) {
            assertEquals(Integer.valueOf(i + 1), list.get(i));
        }

        // Test IndexOutOfBoundsException for negative index
        try {
            list.get(-1);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }

        // Test IndexOutOfBoundsException for index >= size
        try {
            list.get(list.size());
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }
    
    @Test
    public void testSet() {
        ListArray<Integer> list = new ListArray<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        // Test setting elements in the list
        for (int i = 0; i < list.size(); i++) {
            assertEquals(Integer.valueOf(i + 1), list.set(i, i + 11));
        }

        // Check if the elements were updated correctly
        for (int i = 0; i < list.size(); i++) {
            assertEquals(Integer.valueOf(i + 11), list.get(i));
        }

        // Test IndexOutOfBoundsException for negative index
        try {
            list.set(-1, 0);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds: -1", e.getMessage());
        }

        // Test IndexOutOfBoundsException for index >= size
        try {
            list.set(list.size(), 0);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds: " + list.size(), e.getMessage());
        }
    }

    
	@Test
	public void testSize() {
	    List<String> list = new ListArray<>();
	    assertEquals(0, list.size());
	    
	    list.add("hello");
	    assertEquals(1, list.size());
	    
	    list.add("world");
	    assertEquals(2, list.size());
	    
	    list.add(1, "foo");
	    assertEquals(3, list.size());
	    
	    list.remove(0);
	    assertEquals(2, list.size());
	    
	    list.clear();
	    assertEquals(0, list.size());
	}

    
    @Test
    public void testDefaultConstructor() {
        List<String> list = new ListArray<>();
        assertEquals(0, list.size());
    }
    
    @Test
    public void testDefaultConstructorSizeInput() {
        List<String> list = new ListArray<>(10);
        assertEquals(0, list.size());
    }
    
    @Test
    public void testAdd() {
    	ListArray<String> list = new ListArray<>();
        list.add(0, "item1");
        assertEquals("item1", list.get(0));

        list.add(1, "item2");
        assertEquals("item1", list.get(0));
        assertEquals("item2", list.get(1));

        list.add(1, "item3");
        assertEquals("item1", list.get(0));
        assertEquals("item3", list.get(1));
        assertEquals("item2", list.get(2));

        list.add(3, "item4");
        assertEquals("item1", list.get(0));
        assertEquals("item3", list.get(1));
        assertEquals("item2", list.get(2));
        assertEquals("item4", list.get(3));
    }

    private void testAddAtIndex(ListArray<Integer> list) {
        // Test adding elements at specific positions
        list.add(0, 0); // Insert at the beginning
        list.add(6, 100); // Insert in the middle
        list.add(list.size(), 200); // Insert at the end

        Integer[] expected = {0, 1, 2, 3, 4, 5, 100, 6, 7, 8, 9, 10, 200};

        // Check if the elements were added correctly
        for (int i = 0; i < list.size(); i++) {
            assertEquals(expected[i], list.get(i));
        }

        // Test IndexOutOfBoundsException for negative index
        try {
            list.add(-1, 0);
            assert false; // Should not reach this line
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }

        // Test IndexOutOfBoundsException for index > size
        try {
            list.add(list.size() + 1, 0);
            assert false; // Should not reach this line
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    
    @Test
    public void testAddingElements() {
    	List<String> list = new ListArray<>();
    	list.add("hello");
    	list.add("world");
    	list.add("foo");
    	list.add("bar");
    	assertEquals(4, list.size());
    	assertEquals("hello", list.get(0));
    	assertEquals("world", list.get(1));
    	assertEquals("foo", list.get(2));
    	assertEquals("bar", list.get(3));
    }
    
    @Test
    public void testAddingElementsSpecificIndex() {
        List<String> list = new ListArray<>();
        list.add("hello");
        list.add("world");
        list.add(1, "foo");
        assertEquals(3, list.size());
        assertEquals("hello", list.get(0));
        assertEquals("foo", list.get(1));
        assertEquals("world", list.get(2));
        list.add(0, "bar");
        assertEquals(4, list.size());
        assertEquals("bar", list.get(0));
        assertEquals("hello", list.get(1));
        assertEquals("foo", list.get(2));
        assertEquals("world", list.get(3));
        System.out.println("List contents:");
        for (String element : list) {
            System.out.println(element);
        }
    }

    @Test
    public void testAddElement() {
        List<String> list = new ListArray<>();
        assertTrue(list.isEmpty());
        assertTrue(list.add("hello"));
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals("hello", list.get(0));
    }
    
    

    @Test
    public void testAddMultipleElements() {
        List<String> list = new ListArray<>();
        assertTrue(list.add("hello"));
        assertTrue(list.add("world"));
        assertTrue(list.add("foo"));
        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
        assertEquals("hello", list.get(0));
        assertEquals("world", list.get(1));
        assertEquals("foo", list.get(2));
    }

    @Test
    public void testRemovingElements() {
        List<String> list = new ListArray<>();
        list.add("hello");
        list.add("foo");
        list.add("world");

        // Remove element at index 1
        String removed = list.remove(1);
        assertEquals("foo", removed);
        assertEquals(2, list.size());
        assertEquals("hello", list.get(0));
        assertEquals("world", list.get(1));

        // Remove element at index 0
        removed = list.remove(0);
        assertEquals("hello", removed);
        assertEquals(1, list.size());
        assertEquals("world", list.get(0));

        // Remove last element
        removed = list.remove(0);
        assertEquals("world", removed);
        assertEquals(0, list.size());
    }
    
    @Test
    public void testIndexOf() {
        List<String> list = new ListArray<>();
        list.add("hello");
        list.add("world");
        list.add("foo");
        list.add("bar");
        list.add("world");
        assertEquals(1, list.indexOf("world"));
        assertEquals(3, list.indexOf("bar"));
        assertEquals(-1, list.indexOf("baz"));
    }
    
    @Test
    public void testLastIndexOf() {
        List<String> list = new ListArray<>();
        list.add("hello");
        list.add("world");
        list.add("foo");
        list.add("bar");
        list.add("world");

        assertEquals(4, list.lastIndexOf("world"));
        assertEquals(-1, list.lastIndexOf("baz"));
        assertEquals(3, list.lastIndexOf("bar"));
    }
    
    @Test
    public void testSubList() {
        List<String> list = new ListArray<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        List<String> subList = list.subList(1, 4);
        assertEquals(3, subList.size());
        assertEquals("b", subList.get(0));
        assertEquals("c", subList.get(1));
        assertEquals("d", subList.get(2));

        subList.add("f");
        assertEquals(4, subList.size());
        assertEquals("f", subList.get(3));

        assertEquals(5, list.size());
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
        assertEquals("d", list.get(3));
        assertEquals("e", list.get(4));
    }
    
    @Test
    public void testIsEmpty() {
        List<String> list = new ListArray<>();
        assertTrue(list.isEmpty());
        list.add("hello");
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }
    
    @Test
    public void testContains() {
        List<String> list = new ListArray<>();
        assertFalse(list.contains("hello"));

        list.add("hello");
        assertTrue(list.contains("hello"));
        assertFalse(list.contains("world"));

        list.add("world");
        assertTrue(list.contains("hello"));
        assertTrue(list.contains("world"));

        list.add(null);
        assertTrue(list.contains(null));
        assertFalse(list.contains("foo"));
    }
    
    @Test
    public void testIterator() {
        List<String> list = new ListArray<>();
        list.add("hello");
        list.add("world");
        list.add("foo");
        list.add("bar");

        Iterator<String> iterator = list.iterator();

        // Test hasNext() and next()
        assertTrue(iterator.hasNext());
        assertEquals("hello", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("world", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("foo", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("bar", iterator.next());
        assertFalse(iterator.hasNext());
    }
    
    @Test
    public void testToArray() {
        List<String> list = new ListArray<>();
        list.add("hello");
        list.add("world");
        list.add("foo");
        list.add("bar");

        Object[] array = list.toArray();

        // Test that the array has the correct length
        assertEquals(4, array.length);

        // Test that the elements in the array match the elements in the list
        assertEquals("hello", array[0]);
        assertEquals("world", array[1]);
        assertEquals("foo", array[2]);
        assertEquals("bar", array[3]);
    }


    @Test
    public void testRemoveElementNotInList() {
        List<String> list = new ListArray<>();
        list.add("hello");
        list.add("world");

        assertFalse(list.remove("goodbye")); // assert that the element is not in the list
        assertEquals(2, list.size()); // assert that the size of the list has not changed
        assertTrue(list.contains("hello")); // assert that the other element is still in the list
        assertTrue(list.contains("world")); // assert that the other element is still in the list
    }

    @Test
    public void testRemoveFromEmptyList() {
        List<String> list = new ListArray<>();

        assertFalse(list.remove("hello")); // assert that the list is still empty
        assertEquals(0, list.size()); // assert that the size of the list is 0
        assertFalse(list.contains("hello")); // assert that the element is not in the list
    }
    
    @Test
    public void testAddAll() {
        List<String> list = new ListArray<>();
        List<String> toAdd = new ArrayList<>();
        toAdd.add("hello");
        toAdd.add("world");

        assertTrue(list.addAll(toAdd));
        assertEquals(2, list.size());
        assertEquals("hello", list.get(0));
        assertEquals("world", list.get(1));
    }
    
    @Test
    public void testClear() {
    	ListArray<String> list = new ListArray<>();
    	list.add("apple");
    	list.add("banana");
    	list.add("orange");
    	System.out.println(list); // [apple, banana, orange]
    	list.clear();
    	System.out.println(list); // []
    }
 
    @Test
    public void testInsertionOf1000Nodes() {
        ListArray<Integer> list = new ListArray<>();

        // Insert 1000 nodes in a row
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        // Check that the size is correct
        assertEquals(1000, list.size());

        // Check that the elements were added in the correct order
        for (int i = 0; i < 1000; i++) {
            assertEquals(i, (int)list.get(i));
        }
    }


    @Test
    public void testDeletionOf1000Nodes() {
        ListArray<Integer> list = new ListArray<>();

        // Insert 1000 nodes in a row
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        // Delete all the nodes
        while (list.size() > 0) {
            list.remove(list.size() - 1);
        }

        // Check that the size is 0
        assertEquals(0, list.size());
    }
    
    @Test
    public void testSort() {
        ListArray<Integer> list = new ListArray<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);

        // Define a comparator for Integer
        Comparator<Integer> integerComparator = (a, b) -> a.compareTo(b);

        // Sort the list using the comparator
        list.sort(integerComparator);

        // Check if the list is sorted correctly
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
    }
    
    @Test
    public void testToArrayAgain() {
        ListArray<Integer> list = new ListArray<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);

        Object[] expectedArray = new Object[] {5, 3, 1, 4, 2};
        Object[] actualArray = list.toArray();

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testSortWithStrings() {
        ListArray<String> list = new ListArray<>();
        list.add("apple");
        list.add("banana");
        list.add("kiwi");
        list.add("grape");
        list.add("orange");

        // Define a comparator for String
        Comparator<String> stringComparator = (a, b) -> a.compareTo(b);

        // Sort the list using the comparator
        list.sort(stringComparator);

        // Check if the list is sorted correctly
        assertEquals("apple", list.get(0));
        assertEquals("banana", list.get(1));
        assertEquals("grape", list.get(2));
        assertEquals("kiwi", list.get(3));
        assertEquals("orange", list.get(4));
    }

    @Test
    public void testSortEmptyList() {
        ListArray<Integer> list = new ListArray<>();

        // Define a comparator for Integer
        Comparator<Integer> integerComparator = (a, b) -> a.compareTo(b);

        // Sort the empty list using the comparator
        list.sort(integerComparator);

        // Check if the list is still empty
        assertEquals(0, list.size());
    }

    @Test
    public void testSortSingleElementList() {
        ListArray<Integer> list = new ListArray<>();
        list.add(42);

        // Define a comparator for Integer
        Comparator<Integer> integerComparator = (a, b) -> a.compareTo(b);

        // Sort the list with a single element using the comparator
        list.sort(integerComparator);

        // Check if the list has the same single element
        assertEquals(1, list.size());
        assertEquals(42, (int) list.get(0));
    }
    @Test
    public void testToString() {
        ListArray<Integer> list = new ListArray<>();

        // Add elements to the list
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        // Test the toString() method
        String expected = "[1], [2], [3], [4], [5], [6], [7], [8], [9], [10]";
        assertEquals(expected, list.toString());

        // Test with an empty list
        ListArray<Integer> emptyList = new ListArray<>();
        expected = "";
        assertEquals(expected, emptyList.toString());
    }

    
    

}

