package problems;

public class Problem_7 {

	private static ListNode merge(ListNode head1, ListNode head2) {
		ListNode result = null;
		while (head1 != null && head2 != null) {
			ListNode newNode;
			if (head1.val < head2.val) {
				newNode = new ListNode(head1.val);
				head1 = head1.next;
			} else {
				newNode = new ListNode(head2.val);
				head2 = head2.next;
			}
			newNode.next = result;
			result = newNode;
		}
		ListNode rest = head1 != null ? head1 : head2;
		while (rest != null) {
			ListNode newNode = new ListNode(rest.val);
			newNode.next = result;
			result = newNode;
			rest = rest.next;
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode head1 = new ListNode(5);
		head1.next = new ListNode(10);
		head1.next.next = new ListNode(15);
		head1.next.next.next = new ListNode(40);

		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(20);

		ListNode result = merge(head1, head2);
		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
		System.out.print("null");
	}

}
