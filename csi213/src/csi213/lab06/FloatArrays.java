package csi213.lab06;

import java.util.Arrays;

/**
 * This {@code IntArrays} class provides methods for manipulating {@code int} arrays.
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
	public static float sequentialSearch(float[] a, float x) {
		// TODO: add some code here
		
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
	public static float binarySearchRecursive(float[] a, float lower, float upper, float x) {
		// TODO: add some code here
		
		return -1;
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
	public static float binarySearchIterative(float[] a, float x) {
		// TODO: add some code here

		return -1;
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
