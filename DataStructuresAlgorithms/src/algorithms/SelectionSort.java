package algorithms;

public class SelectionSort {
	//My very first sorting algorithm from CS213
	//We go through an entire array, save a min value to a var
	//We want to swap the index with that value, rinse repeat
	// Run time complexity O(n^2) "Quadratic time"
		//Good for small number of elements only
	public static void main(String[] args) {
		
		int arr[] = {8,7,9,2,3,1,5,4,6};
		
		selectionSort(arr);
		
		for (int i : arr) {
			System.out.print(i);
		}
		//Regular for-loop example instead of enhanced
		/*
		for (int j = 0; j < arr.length; j++) { //Traverse length of arr
			int i = arr[j]; //temp variable;
			System.out.print(i);
		}
		*/
	}

	private static void selectionSort(int[] arr) {
		for(int i = 0; i <arr.length-1;i++) { //For the length of the array
			int min = i; //Starting at index zero
			for(int j = i+1; j <arr.length;j++) {
				if(arr[min] > arr[j]) { //Swap sign to make it desc order
					min = j;
				}
			}
			//Swap
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}

}
