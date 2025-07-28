package problems;

import java.util.*;
import java.lang.Math;

public class Problem_22 {
	// O(N) O(k)
	public static void arrayReduction(int N, int k, int[] A) {
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < N; i++) {
			stk.push(A[i]);
			while (stk.size() >= k) {
				int sum = 0;
				int j = 0;
				while (!stk.isEmpty() && j < k) {
					sum = sum + stk.pop();
					j++;
				}
				int avg = (int) Math.floor(sum / k);
				stk.push(avg);
			}

		}
		int size = stk.size();
		int[] result = new int[size];
		for (int i = size - 1; i >= 0; i--) {
			result[i] = stk.pop();
		}
		for (int v : result) {
			System.out.print(v + " ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		sc.close();
		arrayReduction(N, K, A);
	}
}
