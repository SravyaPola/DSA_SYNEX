package linkedlist;

public class ReversalOfLinkedList {

	private static ListNode reversal(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		return prev;
	}

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
		ListNode reversed = reversal(head);
		printList(reversed);
	}
}
