package array;

import java.util.Arrays;

// WAP to find maximum 3 elements from a array with linear time complexity
// int[] numArray = {10, 5, 8, 20, 15, 3, 25, 30};
// output:30,25,20

public class MaxThree {
	public static void main(String[] args) {
		int[] numArray = { 10, 5, 8, 20, 15, 3, 25, 30 };
		int[] result = maxThree(numArray);
		System.out.println(Arrays.toString(result));
	}

	private static int[] maxThree(int[] arr) {
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		int third = Integer.MIN_VALUE;
		for (int i : arr) {
			if (i > first ) {
				third = second;
				second = first;
				first = i;
			} else if (i > second ) {
				third = second;
				second = i;
			} else if (i > third) {
				third = i;
			}
		}
		return new int[] { first, second, third };
	}

}
