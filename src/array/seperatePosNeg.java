package array;

import java.util.Arrays;

//Given an unsorted array arr[] of size N having both negative and positive integers.
//The task is place all negative element at the end of array without changing the order
// of positive element and negative element.
//Example 1:
//Input : N = 8
//arr[] = {1, -1, 3, 2, -7, -5, 11, 6 }
//Output : 
//1  3  2  11  6  -1  -7  -5
//Example 2:
//Input : N=8
//arr[] = {-5, 7, -3, -4, 9, 10, -1, 11}
//Output :
//7  9  10  11  -5  -3  -4  -1

public class seperatePosNeg {
	public static int[] moveNegativesToEnd(int[] arr) {
		int n = arr.length;
		int[] temp = new int[n];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] >= 0) {
				temp[idx++] = arr[i];
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				temp[idx++] = arr[i];
			}
		}
		for (int i = 0; i < n; i++) {
			arr[i] = temp[i];
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, -1, 3, 2, -7, -5, 11, 6 };
		System.out.print(Arrays.toString(moveNegativesToEnd(arr1)));
		int[] arr2 = { -5, 7, -3, -4, 9, 10, -1, 11 };
		System.out.print(Arrays.toString(moveNegativesToEnd(arr2)));
	}
}
