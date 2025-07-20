package sorting;

import java.util.Arrays;

public class ShellSort_4 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 3, 9, 2 };
		System.out.println(Arrays.toString(shellSort(array)));
	}

	private static int[] shellSort(int[] arr) {
		int n = arr.length;
		for (int gap = n / 2; gap >= 1; gap = gap / 2) {
			for (int i = gap; i < n; i++) {
				int temp = arr[i];
				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j = j - gap) {
					arr[j] = arr[j - gap];
				}
				arr[j] = temp;
			}
		}

		return arr;
	}

}
