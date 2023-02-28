package csi213.lab05;

import java.util.Arrays;

/**
 * This {@code FloatArrays} class provides methods for manipulating {@code Float} arrays.
 */
public class FloatArrays {

	/**
	 * Sorts the specified array using the bubble sort algorithm.
	 * 
	 * @param a
	 *            an {@code Float} array
	 */
	public static void bubbleSort(float[] a) {
		System.out.println(Arrays.toString(a));
		for (int last = a.length - 1; last >= 1; last--) { //traverse arr backwards
			for (int i = 0; i < last; i++) {
				if (a[i] > a[i + 1]) { // swap a[i] and a[i + 1]
					float temp = a[i]; //temp var to swap
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

	/**
	 * Sorts the specified array using the selection sort algorithm.
	 * 
	 * @param a
	 *            an {@code Float} array
	 * @param out
	 *            a {@code PrintStream} to show the array at the end of each pass
	 */
	public static void selectionSort(float[] a) {
		System.out.println(Arrays.toString(a));
		for (int last = a.length - 1; last >= 1; last--) {
	        int maxIndex = 0;
	        for (int i = 1; i <= last; i++) {
	            if (a[i] > a[maxIndex]) {
	                maxIndex = i;
	            }
	        }
	        float temp = a[last];
	        a[last] = a[maxIndex];
	        a[maxIndex] = temp;
		}
		System.out.println(Arrays.toString(a));
	}

	/**
	 * Sorts the specified array using the quick sort algorithm.
	 * 
	 * @param a
	 *            an {@code Float} array
	 * @param out
	 *            a {@code PrintStream} to show the array at the end of each pass
	 */
	public static void quickSort(float[] a) {
		System.out.println(Arrays.toString(a));
		quickSort(a, 0, a.length - 1);// calls quick sort, arr, index start, final index
		System.out.println(Arrays.toString(a)); //prints final sorted array
	}
	
	private static void quickSort(float[] a, int low, int high) {
	    if (low < high) {
	        int p = partition(a, low, high);
	        quickSort(a, low, p - 1); //recursion
	        quickSort(a, p + 1, high);
	    }
	}
	//Creates two subarrays, with elements less than the pivot and greater than pivot
	private static int partition(float[] a, int low, int high) {
	    float pivot = a[high]; //pivot at end
	    int i = low - 1;
	    for (int j = low; j < high; j++) {
	        if (a[j] < pivot) {
	            i++;
	            float temp = a[i]; //swap
	            a[i] = a[j];
	            a[j] = temp;
	        }
	    }
	    float temp = a[i + 1]; //swap
	    a[i + 1] = a[high];
	    a[high] = temp;
	    return i + 1;
	}
	

	/**
	 * The main method of the {@code FloatArrays} class.
	 * 
	 * @param args
	 *            the program arguments
	 */
	public static void main(String[] args) {
		float[] a = { 5.3F, 3.8F, 1.2F, 2.7F, 4.99F };
		System.out.println("Bubble Sort:");
		bubbleSort(Arrays.copyOf(a, a.length));
		System.out.println();
		
		System.out.println("Selection Sort:");
		selectionSort(Arrays.copyOf(a, a.length));
		System.out.println();
		
		System.out.println("Quick Sort:");
		quickSort(Arrays.copyOf(a, a.length));
		System.out.println();
	}

}
