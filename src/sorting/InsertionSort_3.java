package sorting;

import java.util.Arrays;

public class InsertionSort_3 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 3, 9, 2 };
		System.out.println(Arrays.toString(insertionSort(array)));
	}

	public static int[] insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		return arr;
	}

}
//Insertion sort builds the sorted array one item at a time by inserting each new element into its place, 
//shifting larger elements as needed.

//At each step, it saves the current element as the “key,” 
//shifts any larger elements in the sorted prefix one position to the right, 
//and then places the key into the newly created gap. 
//This process continues until all elements have been processed, resulting in a fully sorted array.
//Best Case ----- O(n) when the array is already sorted
//Worst case ----- O(n²) comparisons and shifts