package problems;

import java.util.Stack;

public class Problem_4 {

	public static void main(String[] args) {
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);

		Boolean result = isPalindrome(head);
		System.out.println(result);
	}

	private static Boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		Stack<Integer> stack = new Stack<>();
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			if (stack.pop() != slow.val) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

}
