package stacks;

import java.util.*;

public class InfixToPostfixConversion {

	private static int precedence(char ch) {
		if (ch == '^') {
			return 3;
		} else if (ch == '*' || ch == '/') {
			return 2;
		} else if (ch == '+' || ch == '-') {
			return 1;
		}
		return -1;
	}

	private static String conversion(String exp) {
		StringBuilder result = new StringBuilder();
		Stack<Character> stk = new Stack<>();
		for (char ch : exp.toCharArray()) {
			if (Character.isLetterOrDigit(ch)) {
				result.append(ch); // operand - append to result
			} else if (ch == '(') {
				stk.push(ch);
			} else if (ch == ')') {
				while (!stk.isEmpty() && stk.peek() != '(') {
					result.append(stk.pop());
				}
				stk.pop(); // remove '('
			} else { // operator
				while (!stk.isEmpty() && precedence(ch) <= precedence(stk.peek())) {
					result.append(stk.pop());
				}
				stk.push(ch);
			}
		}
		while (!stk.isEmpty()) {
			result.append(stk.pop());
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(conversion("A*B-(C+D)+E"));
	}

}
