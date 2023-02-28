package algorithms;

public class BubbleSort {

	//Traverses arr, compares and swaps, bigger numbers bubble to top
	// Not efficient, even with small dataset
	// O(n^2)
	public static void main(String[] args) {
		float arr[] = {9,1,8,2,7,3,6,4,5};
		
		bubbleSort(arr);
		
		for(float i : arr) {
			System.out.print(i + ", ");
		}


	}

	private static void bubbleSort(float[] arr) {
		for(int i = 0; i < arr.length-1;i++) {
			for(int j = 0; j < arr.length - i -1;i++) {
				if(arr[j] > arr[j+1]) { //Swap with < sign for desc
					float temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

}
