package heap;

import java.util.Arrays;

public class MinHeapAndHeapSort {

	public static void buildMinHeap(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			minHeapify(arr, n, i);
		}
	}

	private static void minHeapify(int[] arr, int heapSize, int i) {
		int smallest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < heapSize && arr[left] < arr[smallest]) {
			smallest = left;
		}
		if (right < heapSize && arr[right] < arr[smallest]) {
			smallest = right;
		}
		if (smallest != i) {
			int tmp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = tmp;
			minHeapify(arr, heapSize, smallest);
		}
	}

	public static void heapSort(int[] arr) {
		int n = arr.length;
		for (int last = n - 1; last > 0; last--) {
			int tmp = arr[0];
			arr[0] = arr[last];
			arr[last] = tmp;
			minHeapify(arr, last, 0);
		}
	}

	public static void minHeapify2(int[] A) {
		int n = A.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			int j = 2 * i + 1;
			boolean heap = false;
			while (j < n && !heap) {
				if (j + 1 < n && A[j + 1] < A[j]) {
					j = j + 1;
				}
				int parent = (j - 1) / 2;
				if (A[j] < A[parent]) {
					int tmp = A[j];
					A[j] = A[parent];
					A[parent] = tmp;
					j = 2 * j + 1;
				} else {
					heap = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 25, 50, 40, 38, 10, 95, 80 };
		System.out.println("Before: " + Arrays.toString(arr));
		minHeapify2(arr);
		System.out.println("After Heapify : " + Arrays.toString(arr));
		heapSort(arr);
		System.out.println("After HeapSort: " + Arrays.toString(arr));
	}
}
