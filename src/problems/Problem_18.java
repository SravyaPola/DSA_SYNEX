package problems;

import java.util.Stack;

public class Problem_18 {

	public static int evaluate(String expr) {
		Stack<Integer> stk = new Stack<>();
		for (char ch : expr.toCharArray()) {
			if (Character.isDigit(ch)) {
				stk.push(ch - '0');
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				int a = stk.pop();
				int b = stk.pop();
				switch (ch) {
				case '+':
					stk.push(b + a);
					break;
				case '-':
					stk.push(b - a);
					break;
				case '*':
					stk.push(b * a);
					break;
				case '/':
					stk.push(b / a);
					break;
				}
			}
		}
		return stk.isEmpty() ? 0 : stk.pop();
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println(evaluate(args[0]));
		} else {
			System.out.println(evaluate("21+3*"));
		}
	}

}
