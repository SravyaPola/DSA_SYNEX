package sorting;

import java.util.Arrays;

public class BubbleSort_1 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 3, 9, 2 };
		System.out.println(Arrays.toString(bubbleSort(array)));
	}

	public static int[] bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			boolean flag = false;
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}
		return array;
	}
}

// Repeatedly “bubbles” larger elements toward the end of the array by swapping adjacent out-of-order pairs, 
// until the entire array is sorted.

//i Counts how many full passes have been completed.
//j Index for the inner loop that scans adjacent pairs from the front up to the “unsorted” boundary
// flag Indicates whether any swap happened during this pass. If no swap occurs, the array is already sorted, so we can stop early

// Worst case: --- Every pass does all comparisons and swaps --- O(n^2)
// Best case ---- Array already sorted. First pass makes no swaps, flag stays false, so we break after one pass