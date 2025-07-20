package problems;

public class Problem_2 {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode result = dummy;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = carry;
			if (l1 != null) {
				sum = sum + l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum = sum + l2.val;
				l2 = l2.next;
			}
			if (sum > 9) {
				carry = 1;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			ListNode newNode = new ListNode(sum);
			dummy.next = newNode;
			dummy = dummy.next;
		}
		if (carry == 1) {
			ListNode newNode = new ListNode(1);
			dummy.next = newNode;
		}
		return result.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next = new ListNode(9);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);

		ListNode result = addTwoNumbers(l1, l2);
		while (result != null) {
			System.out.print(result.val);
			System.out.print("-->");
			result = result.next;
		}
		System.out.print("null");

	}

}
