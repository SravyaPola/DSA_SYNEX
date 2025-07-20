package problems;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class Problem_1 {

	private static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.print("null");
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		printList(head);
		ListNode result = lastNodeBecomingFirst(head);
		printList(result);
	}

	private static ListNode lastNodeBecomingFirst(ListNode head) {
		ListNode current = head;
		ListNode prev = head;
		while (current.next != null) {
			prev = current;
			current = current.next;
		}
		prev.next = null;
		current.next = head;
		return current;
	}
}
