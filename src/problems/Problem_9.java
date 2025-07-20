package problems;

public class Problem_9 {
	private static ListNode swap(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;

		while (prev.next != null && prev.next.next != null) {
			ListNode first = prev.next;
			ListNode second = first.next;
			first.next = second.next;
			prev.next = second;
			second.next = first;
			prev = first;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);

		ListNode result = swap(head);
		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
		System.out.print("null");
	}
}
