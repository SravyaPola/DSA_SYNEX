package problems;

public class Problem_10 {

	private static ListNode removeFromEnd(ListNode head, int end) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode fast = head;
		for (int i = 0; i < end; i++) {
			fast = fast.next;
		}
		ListNode slow = dummy;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode result = removeFromEnd(head, 2);
		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
		System.out.print("null");
	}

}
