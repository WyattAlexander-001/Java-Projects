package algorithms;

public class QuickSort {
	//Recursive Algorithm, divide/conquer
	//Pick Pivot, move to end, and perform swaps
		// median of 3, pick middle value in arr
	//Elements to left should be less than pivot
	//Elements to right are greater than pivot
	// Big O Complexity:
		//Worst case: 0(n^2) -- rare case, if arr is close to being sorted remember n = input size
		//Best case: 0(n log n)
	//Uses more memory since it uses recursion
	public static void main(String[] args) {
		
		int[] arr = {8,2,5,3,9,4,7,6,1};
		
		quickSort(arr,0,arr.length-1);
		
		//Display arr:
		for(int i : arr) {
			System.out.print(i + ",");
		}
	}

	private static void quickSort(int[] arr, int start, int end) {
		if(end <= start) {
			return; //base case
		}
		
		int pivot = partition(arr,start,end);
		quickSort(arr,start,pivot-1);
		quickSort(arr,pivot+1,end);
		
	}
	
	//Helper Function:
	private static int partition(int[] arr, int start, int end) {
		
		int pivot = arr[end];
		int i = start -1;
		
		for(int j = start; j <= end ;j++) {
			if(arr[j] <pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		i++;
		int temp = arr[i];
		arr[i] = arr[end];
		arr[end] = temp;
		return i;
	}

}
