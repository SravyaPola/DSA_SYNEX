package problems;

public class Problem_6 {

	private static void mergeLists(ListNode list1, ListNode list2) {
		if (list1 == null || list2 == null) {
			return;
		}
		ListNode p1 = list1;
		while (p1 != null && list2 != null) {
			if (p1.val > list2.val) {
				int temp = p1.val;
				p1.val = list2.val;
				list2.val = temp;

				ListNode newNode = list2;
				list2 = list2.next;
				if (list2 == null || newNode.val <= list2.val) {
					newNode.next = list2;
					list2 = newNode;
				} else {
//					ListNode prev = list2, curr = list2.next;
//					while (curr != null && curr.val < newNode.val) {
//						prev = curr;
//						curr = curr.next;
//					}
//					prev.next = newNode;
//					newNode.next = curr;
					ListNode current = list2;
					while (current.next != null && current.next.val < newNode.val) {
						current = current.next;
					}
					newNode.next = current.next;
					current.next = newNode;
				}
			}
			p1 = p1.next;
		}
	}

	private static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.print("null");
		System.out.println();
	}

	// Example usage
	public static void main(String[] args) {
		// First List: 2->4->7->8->10
		ListNode head1 = new ListNode(2);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(7);
		head1.next.next.next = new ListNode(8);
		head1.next.next.next.next = new ListNode(10);

		// Second List: 1->3->12
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(12);

		System.out.print("Before:\n  List1: ");
		printList(head1);
		System.out.print("  List2: ");
		printList(head2);

		mergeLists(head1, head2);

		System.out.print("After:\n  List1: ");
		printList(head1);
		System.out.print("  List2: ");
		printList(head2);
	}

}
