package algorithms;

public class InsertionSort {
	//https://www.youtube.com/watch?v=8mJ-OhcfpYg
	//Begin at index 1, save to temp var
	//Check index 0, compare to temp
		//if value is < we stop or continue
		//if value is greater we swap
	//0(n^2) similar to bubble sort/selection sort speed. 
		//Best case is 0(n) linear time
	public static void main(String[] args) {
		
		int arr[] = {9,1,8,2,7,3,6,5,4};
		
		insertionSort(arr);
		
		//Display arr
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void insertionSort(int[] arr) {
		for(int i =1;i<arr.length;i++) {
			int temp = arr[i];
			int j = i -1;
			
			while(j >= 0 && arr[j] >temp) {
				arr[j+1] = arr[j]; //shift to right
				j--;
			}
			arr[j+1] = temp; 
		}
	}

}
