package csi213.assignment3;

import java.util.*;

public class ListArray<T> implements List<T> {
	
	private Node<T> head;
	private int size;
	private int smallArraySize; // Add this instance variable to store the small array size
	private static int defaultArraySize = 5;

	public ListArray() {
	    this(defaultArraySize);
	}

	public ListArray(int smallArraySize) {
	    head = new Node<>(smallArraySize);
	    size = 0;
	    this.smallArraySize = smallArraySize; // Assign the instance variable instead of modifying the default
	}

	public class Node<T> {
	    T[] data;
	    Node<T> next;

	    @SuppressWarnings("unchecked")
	    public Node(int size) {
	        data = (T[]) new Object[size];
	        next = null;
	    }
	}

	@Override
	public T get(int index) {
	    if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException("Index out of bounds");
	    }

	    Node<T> current = head;
	    int currentIndex = 0;

	    while (current != null) {
	        int arraySize = current.data.length;
	        for (int i = 0; i < arraySize; i++) {
	            if (currentIndex == index) {
	                return current.data[i];
	            }
	            if (current.data[i] != null) {
	                currentIndex++;
	            }
	        }
	        current = current.next;
	    }

	    return null;
	}

	@Override
	public T set(int index, T element) {
	    if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
	    }

	    Node<T> current = head;
	    int currentIndex = 0;

	    while (current != null) {
	        int arraySize = current.data.length;
	        for (int i = 0; i < arraySize; i++) {
	            if (currentIndex == index) {
	                T oldValue = current.data[i];
	                current.data[i] = element;
	                return oldValue;
	            }
	            if (current.data[i] != null) {
	                currentIndex++;
	            }
	        }
	        current = current.next;
	    }

	    return null;
	}


   private void moveToNextNode(Node<T> currentNode, T element) {
	    while (currentNode != null) {
	        boolean elementInserted = false;
	        for (int i = 0; i < currentNode.data.length; i++) {
	            if (currentNode.data[i] == null) {
	                currentNode.data[i] = element;
	                elementInserted = true;
	                break;
	            }
	        }
	        if (elementInserted) {
	            break;
	        } else {
	            if (currentNode.next == null) {
	                currentNode.next = new Node<>(defaultArraySize);
	            }
	            currentNode = currentNode.next;
	        }
	    }
	}

   @Override
   public void add(int index, T element) {
       if (index < 0 || index > size) {
           throw new IndexOutOfBoundsException("Index out of bounds");
       }

       if (isEmpty()) {
           head = new Node<>(smallArraySize);
       }

       int nodeIndex = index / smallArraySize;
       int arrayIndex = index % smallArraySize;
       Node<T> currentNode = head;

       for (int i = 0; i < nodeIndex; i++) {
           if (currentNode.next == null) {
               currentNode.next = new Node<>(smallArraySize);
           }
           currentNode = currentNode.next;
       }

       if (currentNode.data[arrayIndex] == null) {
           currentNode.data[arrayIndex] = element;
       } else {
           T displacedElement = currentNode.data[arrayIndex];
           currentNode.data[arrayIndex] = element;

           while (displacedElement != null) {
               arrayIndex++;

               if (arrayIndex >= smallArraySize) {
                   if (currentNode.next == null) {
                       currentNode.next = new Node<>(smallArraySize);
                   }
                   currentNode = currentNode.next;
                   arrayIndex = 0;
               }

               T temp = currentNode.data[arrayIndex];
               currentNode.data[arrayIndex] = displacedElement;
               displacedElement = temp;
           }
       }

       size++;
   }

  
    @Override
    public boolean add(T t) {
        add(size, t);
        return true;
    }
    
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current = head;
        int currentIndex = 0;
        T removedElement = null;

        while (current != null) {
            int arraySize = current.data.length;
            for (int i = 0; i < arraySize; i++) {
                if (currentIndex == index) {
                    removedElement = current.data[i];

                    // Shift elements to the left
                    for (int j = i; j < arraySize - 1; j++) {
                        current.data[j] = current.data[j + 1];
                    }
                    current.data[arraySize - 1] = null;

                    // If the current Node is now empty, remove it
                    if (i == 0 && current.data[i] == null) {
                        removeNode(current);
                    }

                    size--;
                    return removedElement;
                }
                if (current.data[i] != null) {
                    currentIndex++;
                } else {
                    break;
                }
            }
            current = current.next;
        }
        return removedElement;
    }

    private void removeNode(Node<T> nodeToRemove) {
        if (head == nodeToRemove) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next == nodeToRemove) {
                current.next = nodeToRemove.next;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public int indexOf(Object o) {
        Node<T> current = head;
        int index = 0;

        // Iterate through the Nodes
        while (current != null) {
            // Iterate through the array inside the Node
            for (int i = 0; i < current.data.length; i++) {
                if (index >= size) {
                    break;
                }

                // Check if the object at the current index is equal to the given object
                if (Objects.equals(current.data[i], o)) {
                    return index;
                }
                index++;
            }
            current = current.next;
        }
        // Return -1 if the object is not found
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> current = head;
        int index = 0;
        int lastIndex = -1;

        // Iterate through the Nodes
        while (current != null) {
            // Iterate through the array inside the Node
            for (int i = 0; i < current.data.length; i++) {
                if (index >= size) {
                    break;
                }

                // Check if the object at the current index is equal to the given object
                if (Objects.equals(current.data[i], o)) {
                    lastIndex = index;
                }
                index++;
            }
            current = current.next;
        }
        // Return the last index of the object, or -1 if the object is not found
        return lastIndex;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }

        // Create a new ListArray to store the subList
        ListArray<T> subList = new ListArray<>();

        Node<T> currentNode = head;
        int currentIndex = 0;
        int subListIndex = 0;

        // Iterate through the Nodes
        while (currentNode != null) {
            // Iterate through the array inside the Node
            for (int i = 0; i < currentNode.data.length; i++) {
                if (currentIndex >= size) {
                    break;
                }

                // Check if the current index is within the range of fromIndex and toIndex
                if (currentIndex >= fromIndex && currentIndex < toIndex) {
                    // Add the element to the subList
                    subList.add(subListIndex, currentNode.data[i]);
                    subListIndex++;
                }
                currentIndex++;
            }
            currentNode = currentNode.next;
        }

        // Return the subList
        return subList;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        while (current != null) {
            for (T element : current.data) {
                if (Objects.equals(element, o)) {
                    return true;
                }
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> currentNode = head;
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                T value = currentNode.data[currentIndex];
                currentIndex++;
                if (currentIndex >= currentNode.data.length) {
                    currentNode = currentNode.next;
                    currentIndex = 0;
                }
                return value;
            }
        };
    }



    @Override
    public boolean remove(Object o) {
        Node<T> currentNode = head;
        Node<T> previousNode = null;
        while (currentNode != null) {
            for (int i = 0; i < currentNode.data.length; i++) {
                if (currentNode.data[i] != null && currentNode.data[i].equals(o)) {
                    currentNode.data[i] = null;
                    size--;
                    if (currentNode.data[0] == null) {
                        // If current node is the head, update head to next node
                        if (previousNode == null) {
                            head = currentNode.next;
                        } else {
                            // Update previous node to skip current node
                            previousNode.next = currentNode.next;
                        }
                    }
                    return true;
                }
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] arr = c.toArray();
        int len = arr.length;
        if (len == 0) {
            return false;
        }
        Node<T> current = head;
        int i = 0;
        while (current != null && i + current.data.length <= index) {
            i += current.data.length;
            current = current.next;
        }
        int j = index - i;
        while (j >= current.data.length) {
            j -= current.data.length;
            current = current.next;
        }
        int k = 0;
        while (k < len) {
            if (j == current.data.length) {
                current = new Node<T>(defaultArraySize);
                current.next = current.next;
                j = 0;
            }
            current.data[j] = (T) arr[k];
            j++;
            k++;
            size++;
        }
        return true;
    }

//=================================================
    public void sort(Comparator<? super T> c) {
        if (head == null || head.next == null) {
            return;
        }
        T[] arr = toArray();
        quicksort(arr, 0, size - 1, c);
        updateListFromArray(arr);
    }

    public void quicksort(T[] arr, int low, int high, Comparator<? super T> c) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, c);
            quicksort(arr, low, pivotIndex - 1, c);
            quicksort(arr, pivotIndex + 1, high, c);
        }
    }

    public int partition(T[] arr, int low, int high, Comparator<? super T> c) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (c.compare(arr[j], pivot) <= 0) {
                i++;

                // Swap the elements at i and j
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap the elements at i+1 and high
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            for (T element : current.data) {
                if (element != null) {
                    array[index] = element;
                    index++;
                    if (index == size) {
                        break;
                    }
                }
            }
            current = current.next;
        }
        return array;
    }

    public void updateListFromArray(T[] arr) {
        Node<T> currentNode = head;
        int dataIndex = 0;
        for (T item : arr) {
            currentNode.data[dataIndex] = item;
            dataIndex++;
            if (dataIndex == currentNode.data.length) {
                currentNode = currentNode.next;
                dataIndex = 0;
            }
        }
    }



//=================================================
    @Override
    public void clear() {
        head = new Node<>(defaultArraySize);
        size = 0;
    }
    
    
    Comparator<Node<T>> comp = new Comparator<Node<T>>() {
        @SuppressWarnings("unchecked")
        @Override
        public int compare(Node<T> o1, Node<T> o2) {
            return ((Comparable<T>) o1.data[0]).compareTo(o2.data[0]);
        }
    };

    /*
    Comparator<T> comp = new Comparator<T>() {
        @SuppressWarnings("unchecked")
        @Override
        public int compare(T o1, T o2) {
            // Always return 0 to test if the Comparator is being used properly
            return 0;
        }
    };
    */


    @Override
    public boolean removeAll(Collection<?> c) {
        return false; // DO NOT IMPLEMENT THIS
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false; // DO NOT IMPLEMENT THIS
    }
    @Override
    public ListIterator<T> listIterator() {
        return null; // DO NOT IMPLEMENT THIS
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null; // DO NOT IMPLEMENT THIS
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false; // DO NOT IMPLEMENT THIS
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null; // DO NOT IMPLEMENT THIS
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node<T> currentNode = head;
        while (currentNode != null) {
            for (int i = 0; i < currentNode.data.length; i++) {
                if (currentNode.data[i] != null) {
                    if (sb.length() > 0) { // Add a comma and a space for all elements except the first one
                        sb.append(", ");
                    }
                    sb.append("[").append(currentNode.data[i]).append("]");
                }
            }
            currentNode = currentNode.next;
        }

        return sb.toString();
    }


    
    //Bubble sort test for debugging
    public void bubbleSort(Comparator<? super T> c) {
        if (head == null || head.next == null) {
            return;
        }
        
        boolean swapped = true;
        Node<T> current = head;
        Node<T> prev = null;
        Node<T> nextNode = null;
        while (swapped) {
            swapped = false;
            while (current != null && current.next != null) {
                nextNode = current.next;
                if (c.compare(current.data[0], nextNode.data[0]) > 0) {
                    // Swap the data in the nodes
                    T temp = current.data[0];
                    current.data[0] = nextNode.data[0];
                    nextNode.data[0] = temp;
                    swapped = true;
                }
                prev = current;
                current = current.next;
            }
            current = head;
        }
    }



}

