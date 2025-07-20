package stacks;

import java.util.Stack;

public class DecimalToBinary {

	public static String decToBin(int n) {
		if (n == 0)
			return "0";
		Stack<Integer> stack = new Stack<>();
		int num = n;
		while (num > 0) {
			stack.push(num % 2);
			num /= 2;
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(decToBin(13));
		System.out.println(decToBin(42));
	}
}
