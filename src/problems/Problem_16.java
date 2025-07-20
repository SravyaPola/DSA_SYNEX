package problems;

import java.util.Stack;

public class Problem_16 {
	public static int problem_16(String s) {
		int max = (1 << 20) - 1;
		Stack<Integer> stk = new Stack<>();
		for (String str : s.split(" ")) {
			if (str.equals("POP")) {
				if (!stk.isEmpty()) {
					stk.pop();
				}
			} else if (str.equals("DUP")) {
				if (!stk.isEmpty()) {
					stk.push(stk.peek());
				}
			} else if (str.equals("+")) {
				if (stk.size() >= 2) {
					int a = stk.pop();
					int b = stk.pop();
					if (a + b > max) {
						return -1;
					}
					stk.push(a + b);
				} else {
					return -1;
				}
			} else if (str.equals("-")) {
				if (stk.size() >= 2) {
					int a = stk.pop();
					int b = stk.pop();
					if (a - b < 0) {
						return -1;
					}
					stk.push(a - b);
				} else {
					return -1;
				}
			} else {
				int x = Integer.parseInt(str);
				if (x < 0 || x > max) {
					return -1;
				}
				stk.push(x);
			}
		}
		return stk.isEmpty() ? 0 : stk.peek();
	}

	public static void main(String[] args) {
		String a = "4 5 6 - 7 +";
		System.out.println(problem_16(a));
		String b = "13 DUP 4 POP 5 DUP + DUP + -";
		System.out.println(problem_16(b));
		String c = "5 6 + -";
		System.out.println(problem_16(c));
		String d = "3 DUP 5 - -";
		System.out.println(problem_16(d));
		String e = "1048575 DUP +";
		System.out.println(problem_16(e));
	}
}
