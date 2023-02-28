package algorithms;

public class SequentialSearch {

	//Search an arr for a SPECIFIC Element
	//Use loop to iterate, compare to search val, stop when found or when end
	
	public static void main(String[] args) {
		
		int[] arr = {45, 67, 23, 50, 1, 505, 54, 40, 90};
		
		System.out.println(sequentailSearch(arr, 999)); // -1
		System.out.println(sequentailSearch(arr, 67)); // 1
		System.out.println(sequentailSearch(arr, 90)); // 8
		

	}

	public static int sequentailSearch(int[] arr, int key) {
		for(int i=0; i<arr.length;i++) {
			if(arr[i] == key)
				return i;
		}
		return -1;
		
	}

}
