package linkedlist;

public class DeleteByDiff {

//	delete node from a singly  list at the given difference.
//	input:[1,2,3,4,5,6,7,8]
//	difference=2
//	output:[1,4,7]

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
		head.getNext().getNext().getNext().setNext(new ListNode(5));
		head.getNext().getNext().getNext().getNext().setNext(new ListNode(6));
		head.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(7));
		head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(8));
		printList(head);
		int diff = 1;
		ListNode result = delete(head, diff);
		printList(result);
	}

	private static ListNode delete(ListNode head, int diff) {
		ListNode current = head;
		ListNode result = head;
		ListNode dummy = result;
		while (current != null) {
			int count = 0;
			while (count <= diff && current != null) {
				current = current.getNext();
				count++;
			}
			dummy.setNext(current);
			dummy = dummy.getNext();
		}
		return result;
	}

}
