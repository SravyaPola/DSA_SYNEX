package assessment2;

import java.util.*;

public class QueueProblem {

	private static int totalSeconds(int N, int[] arr) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			q.add(arr[i]);
		}
		int time = 0;
		while (!q.isEmpty()) {
			int current = q.poll();
			if (current > 1) {
				int done = current / 2;
				int remaining = current - done;
				q.add(remaining);
			}
			time++;
		}
		return time;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 1 };
		int N = 3;
		System.out.println(totalSeconds(N, arr));
	}

}
