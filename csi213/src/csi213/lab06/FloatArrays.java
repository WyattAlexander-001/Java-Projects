package csi213.lab06;

import java.util.Arrays;

/**
 * This {@code FloatArrays} class provides methods for manipulating {@code float} arrays.
 * 
 * @author Jeong-Hyon Hwang (jhh@cs.albany.edu)
 */
public class FloatArrays {

	/**
	 * Finds the location of the specified value (the index at which the specified value is stored) in the specified
	 * array by examining each element until the value is found.
	 * 
	 * @param a
	 *            an {@code float} array
	 * @param x
	 *            an {@code float} value
	 * @return the location of the specified value (the index at which the specified value is stored) in the specified
	 *         array; {@code -1} if the specified value is not in the array
	 */
	public static int sequentialSearch(float[] a, float x) {
		for(int i=0; i<a.length;i++) {
			if(a[i] == x)
				return i;
		}
		return -1;
	}

	/**
	 * Finds the location of the specified value (the index at which the specified value is stored) in the specified
	 * sorted array using the recursive binary search algorithm.
	 * 
	 * @param a
	 *            an {@code float} array that is known to be sorted
	 * @param lower
	 *            an index representing the lower bound of the binary search
	 * @param upper
	 *            an index representing the upper bound of the binary search
	 * @param x
	 *            an {@code float} value
	 * @return the location of the specified value (the index at which the specified value is stored) in the specified
	 *         array; {@code -1} if the specified value is not in the array
	 */
	public static int binarySearchRecursive(float[] a, float lower, float upper, float x) {
	    if (upper >= lower) {
	        int middleIndex = (int) (lower + (upper - lower) / 2);   
	        if (a[middleIndex] == x) { // Best case is in middle
	            return middleIndex;
	        } else if ( x < a[middleIndex]){ // If element is < than mid, then element is in left array
	            return binarySearchRecursive(a, lower, middleIndex - 1, x);
	        } else { //If element is > than mid, then element is in right array
		        return binarySearchRecursive(a, middleIndex + 1, upper, x);
	        }
	    }	
		return -1; //DNE
	}

	/**
	 * Finds the location of the specified value (the index at which the specified value is stored) in the specified
	 * sorted array using the iterative binary search algorithm.
	 * 
	 * @param a
	 *            an {@code float} array that is known to be sorted
	 * @param x
	 *            an {@code float} value
	 * @return the location of the specified value (the index at which the specified value is stored) in the specified
	 *         array; {@code -1} if the specified value is not in the array
	 */
	public static int binarySearchIterative(float[] a, float x) {
        int left = 0; 
        int right = a.length - 1; //final index
 
        while (left <= right){ //loop until success
            int middleIndex = (left + right) / 2;
            if (x == a[middleIndex]) { //Best case if in middle of arr
                return middleIndex;
            }
            else if (x < a[middleIndex]) {
                right = middleIndex - 1;
            }
            else {
                left = middleIndex + 1;
            }
        }
		return -1; //DNE
	}

	/**
	 * The main method of the {@code IntArrays} class.
	 * 
	 * @param args
	 *            the program arguments
	 */
	public static void main(String[] args) {
		float[] a = { 5.1f, 3.2f, 1.7f, 2.6f, 4.4f };
		float[] b = { 1.4f, 3.5f, 5.2f, 7.2f, 9.2f, 11.2f, 13.8f };

		System.out.println(sequentialSearch(a, 2.6f));
		System.out.println(sequentialSearch(a, 7.2f));
		System.out.println(sequentialSearch(b, 2.3f));
		System.out.println(sequentialSearch(b, 7.2f));
		System.out.println();

		System.out.println(binarySearchRecursive(a, 0, a.length - 1, 2.6f));
		System.out.println(binarySearchRecursive(a, 0, a.length - 1, 7.2f));
		System.out.println(binarySearchRecursive(b, 0, b.length - 1, 2.3f));
		System.out.println(binarySearchRecursive(b, 0, b.length - 1, 7.2f));
		System.out.println();

		System.out.println(binarySearchIterative(a, 2.6f));
		System.out.println(binarySearchIterative(a, 7.2f));
		System.out.println(binarySearchIterative(b, 2.6f));
		System.out.println(binarySearchIterative(b, 7.2f));
		System.out.println();
	}

}
