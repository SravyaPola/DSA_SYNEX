package linkedlist;

public class LastNodeBecomingFirst {
	private static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.getData() + "->");
			node = node.getNext();
		}
		System.out.print("null");
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.setNext(new ListNode(2));
		head.getNext().setNext(new ListNode(3));
		head.getNext().getNext().setNext(new ListNode(4));
		printList(head);
		ListNode result = lastNodeBecomingFirst(head);
		printList(result);
	}

	private static ListNode lastNodeBecomingFirst(ListNode head) {
		ListNode current = head;
		ListNode prev = head;
		while (current.getNext() != null) {
			prev = current;
			current = current.getNext();
		}
		prev.setNext(null);
		current.setNext(head);
		return current;
	}
}
