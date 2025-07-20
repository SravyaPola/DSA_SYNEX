package stacks;

import java.util.Stack;

public class ValidParentheses {

	public static boolean isValid(String s) {
		Stack<Character> stk = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				stk.push(ch);
			} else if (ch == ')' || ch == '}' || ch == ']') {
				if (!stk.isEmpty()) {
					if (ch == ')' && stk.peek() == '(') {
						stk.pop();
					} else if (ch == '}' && stk.peek() == '{') {
						stk.pop();
					} else if (ch == ']' && stk.peek() == '[') {
						stk.pop();
					} else { // Mismatch found
						return false;
					}
				} else { // there's no matching opening bracket by count
					return false;
				}
			}
		}
		return stk.isEmpty();
		// if every opening bracket had a matching closing bracket then stack is empty
		// and valid
	}

	public static void main(String[] args) {
		String a = "()";
		System.out.println(isValid(a));
		String b = "()[]{}";
		System.out.println(isValid(b));
		String c = "(]";
		System.out.println(isValid(c));
		String d = "([])";
		System.out.println(isValid(d));
		String e = "{(a + b) × (c + d) + (c × d)}";
		System.out.println(isValid(e));
	}

}
