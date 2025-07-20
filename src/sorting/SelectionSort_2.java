package sorting;

import java.util.Arrays;

public class SelectionSort_2 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 3, 9, 2 };
		System.out.println(Arrays.toString(selectionSort(array)));
	}

	public static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		return arr;
	}
}
//Selection sort repeatedly selects the smallest remaining element and moves it into its correct position. 
//Starting at the first index, it scans the rest of the array to find the minimum value, 
//then swaps that value with the element at the current index. 
//It then advances one position and repeats this process on the unsorted portion. 
//By the time it has processed all but the last element, the array is fully sorted in ascending order. 
//This in-place algorithm runs in quadratic time (O(n²)) and uses only constant extra space.
