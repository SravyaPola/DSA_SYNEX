package problems;

public class Problem_5 {

	public static ListNode reverseConsecutiveEven(ListNode head) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode prev = dummy;
		ListNode current = head;
		while (current != null) {
			if (current.val % 2 != 0) {
				prev = current;
				current = current.next;
			} else {
				ListNode start = current;
				while (current != null && current.val % 2 == 0) {
					current = current.next;
				}
				ListNode end = current;
				ListNode reversed = reversed(start, end);
				prev.next = reversed;
				start.next = current;
				prev = start;
			}
		}
		return dummy.next;
	}

	private static ListNode reversed(ListNode start, ListNode end) {
		ListNode prev = null;
		ListNode current = start;
		while (current != end) {
			ListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return prev;
	}

	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.print("null");
		System.out.println();
	}

	public static void main(String[] args) {
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(8);
//		head.next.next.next = new ListNode(9);
//		head.next.next.next.next = new ListNode(12);
//		head.next.next.next.next.next = new ListNode(16);
//		head.next.next.next.next.next.next = new ListNode(17);

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next = new ListNode(5);
		System.out.print("Before : ");
		printList(head);
		ListNode result = reverseConsecutiveEven(head);
		System.out.print("After : ");
		printList(result);
	}

}
