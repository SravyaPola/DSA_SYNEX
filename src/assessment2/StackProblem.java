package assessment2;

// LC - 277
import java.util.*;

public class StackProblem {

	private static int[][] arr = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };

	public static int findId(int n) {
		if (n <= 0) {
			return -1;
		}
		if (n == 1) {
			return 0;
		}
		Stack<Integer> stk = new Stack<>();

		for (int i = 0; i < n; i++) {
			stk.push(i);
		}

		while (stk.size() > 1) {
			int a = stk.pop();
			int b = stk.pop();

			if (knows(a, b)) {
				stk.push(b);
			} else {
				stk.push(a);
			}
		}
		int teacher = stk.pop();
		for (int i = 0; i < n; i++) {
			if (i == teacher) {
				continue;
			}
			if (knows(teacher, i) || !knows(i, teacher)) {
				return -1;
			}
		}
		return teacher;
	}

	private static boolean knows(int a, int b) {
		if (arr[a][b] == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(findId(arr.length));
	}
}
