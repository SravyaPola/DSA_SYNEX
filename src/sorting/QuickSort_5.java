package sorting;

import java.util.Arrays;

public class QuickSort_5 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 3, 9, 2 };
		int low = 0;
		int high = array.length - 1;
		quickSort(array, low, high);
		System.out.print(Arrays.toString(array));
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int partion = partionIndex(arr, low, high);
			quickSort(arr, low, partion - 1);
			quickSort(arr, partion + 1, high);
		}
	}

	private static int partionIndex(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i = low;
		int j = high;
		while (i < j) {
			while (i <= high && arr[i] <= pivot) {
				i++;
			}
			while (j >= low && arr[j] > pivot) {
				j--;
			}
			if (i < j) {
				swap(arr, i, j);
			}
		}
		swap(arr, low, j);
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
