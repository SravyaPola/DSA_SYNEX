package problems;

import java.util.List;
import java.util.ArrayList;

//Java Program to find pairs on integer array whose sum is equal to k
//[Given array : [2, 4, 13, 15, 7, 8, 9]
//Given sum : 17
//Integer numbers, whose sum is equal to value : 17
//(2, 15)
//(4, 13)
//(8,9)]

public class ListOfAllTwoSum {
	public static void main(String[] args) {
		int[] array = { 2, 4, 13, 15, 7, 8, 9 };
		int sum = 17;
		List<List<Integer>> result = findList(array, sum);
		System.out.println(result);
	}

	private static List<List<Integer>> findList(int[] array, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] == sum) {
					List<Integer> ls = new ArrayList<>();
					ls.add(array[i]);
					ls.add(array[j]);
					result.add(ls);
				}
			}
		}
		return result;
	}
}
