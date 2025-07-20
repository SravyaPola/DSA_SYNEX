package sorting;

import java.util.Arrays;

public class MergeSort_6 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 3, 9, 2 };
		int low = 0;
		int high = array.length - 1;
		mergeSort(array, low, high);
		System.out.print(Arrays.toString(array));
	}

	private static void mergeSort(int[] array, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
	}

	private static void merge(int[] array, int low, int mid, int high) {
		int l1 = mid - low + 1;
		int l2 = high - mid;
		int[] arr1 = new int[l1];
		int[] arr2 = new int[l2];
		for (int i = 0; i < l1; i++) {
			arr1[i] = array[low + i];
		}
		for (int j = 0; j < l2; j++) {
			arr2[j] = array[mid + 1 + j];
		}
		int i = 0;
		int j = 0;
		int k = low;
		while (i < l1 && j < l2) {
			if (arr1[i] < arr2[j]) {
				array[k] = arr1[i];
				i++;
			} else {
				array[k] = arr2[j];
				j++;
			}
			k++;
		}
		while (i < l1) {
			array[k] = arr1[i];
			i++;
			k++;
		}
		while (j < l2) {
			array[k] = arr2[j];
			j++;
			k++;
		}
	}
}
