package problems;

import java.util.Stack;

public class Problem_19 {

	public static Stack<Integer> sort(Stack<Integer> stk) {
		Stack<Integer> temp = new Stack<Integer>();
		while (!stk.isEmpty()) {
			int curr = stk.pop();
			while (!temp.isEmpty() && temp.peek() > curr) {
				stk.push(temp.pop());
			}
			temp.push(curr);
		}
		return temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 34, 3, 31, 98, 92, 23 };
		Stack<Integer> stk = new Stack<>();
		for (int a : arr) {
			stk.push(a);
		}
		System.out.println(sort(stk));
	}

}
