package array;

import java.util.Arrays;

//WAP find maximum product of two integers in an array without sorting
//eg:
//int[] A = { 11, 23, 15, 6, -35,-35 ,34};
//output:Pair is (23, 34)
//int[] A = { 11, 23, 15, 6, -35,-35 ,34};
//Pair is (-35, -35)

public class MaxProduct {

	public static void main(String[] args) {
		int[] A = { 1, 4, 3, 6, 7, 0 };
		int[] B = { -1, -3, -4, 2, 0, -5 };
		System.out.println(Arrays.toString(maxProduct(A)));
		System.out.println(Arrays.toString(maxProduct(B)));
	}

	private static int[] maxProduct(int[] arr) {
		int posA = Integer.MIN_VALUE;
		int posB = Integer.MIN_VALUE;
		int negA = Integer.MIN_VALUE;
		int negB = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > posA) {
				posB = posA;
				posA = arr[i];
			} else if (arr[i] > posB) {
				posB = arr[i];
			}
			if (arr[i] < 0 && Math.abs(arr[i]) > Math.abs(negA)) {
				negB = negA;
				negA = arr[i];
			} else if (arr[i] < 0 && Math.abs(arr[i]) > Math.abs(negB)) {
				negB = arr[i];
			}
		}
		if (posA * posB > negA * negB) {
			return new int[] { posA, posB };
		} else {
			return new int[] { negA, negB };
		}
	}
}
