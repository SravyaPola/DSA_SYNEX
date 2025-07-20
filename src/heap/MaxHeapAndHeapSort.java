package heap;

import java.util.Arrays;

public class MaxHeapAndHeapSort {

	public static void buildMaxHeap(int[] arr) {
		int n = arr.length;
		// parent node for any -- (n - 1)/ 2, last non leaf node is where we should
		// start
		// heapifying so,
		// In array last element is n - 1 so the arrays last elements parent is the last
		// non
		// leaf node in tree
		// so ((n-1) - 1)/2 ==> (n-2)/2 ==> n/2 - 1
		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapify(arr, n, i);
		}
	}

	// i is the root index of the subtree to heapify
	private static void maxHeapify(int[] arr, int heapSize, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < heapSize && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < heapSize && arr[right] > arr[largest]) {
			largest = right;
		}
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			maxHeapify(arr, heapSize, largest);
		}
	}

	public static void heapSort(int[] arr) {
		int n = arr.length;
		// For every Iteration, we will sort element from last leaving largest to the
		// last,then heapify from root to the last - 1, we will
		// proceed to previous of last this process continues until we reach the root
		for (int last = n - 1; last > 0; last--) {
			int temp = arr[0];
			arr[0] = arr[last];
			arr[last] = temp;
			maxHeapify(arr, last, 0);
		}
	}

	public static void maxHeapify2(int[] A) {
		int n = A.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			int j = 2 * i + 1;
			boolean heap = false;
			while (j < n && !heap) {
				if (j + 1 < n && A[j + 1] > A[j]) {
					j = j + 1;
				}
				int parent = (j - 1) / 2;
				if (A[j] > A[parent]) {
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
//		buildMaxHeap(arr);
//		System.out.println("After : " + Arrays.toString(arr));
		maxHeapify2(arr);
		System.out.println("After Heapify: " + Arrays.toString(arr));
		heapSort(arr);
		System.out.println("After Heap Sort: " + Arrays.toString(arr));

	}

}
