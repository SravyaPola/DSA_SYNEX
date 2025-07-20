package stacks;

import java.util.Stack;

public class BinaryToDecimal {

	public static int binToDec(String bin) {
		Stack<Integer> stack = new Stack<>();
		for (char c : bin.toCharArray()) {
			stack.push(c == '1' ? 1 : 0);
		}
		int result = 0;
		int multiplier = 1;

		while (!stack.isEmpty()) {
			if (stack.pop() == 1) {
				result += multiplier;
			}
			multiplier = multiplier + multiplier;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(binToDec("1101"));
		System.out.println(binToDec("101010"));
	}
}
