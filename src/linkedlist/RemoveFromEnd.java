package linkedlist;

//Given the head of a linked list, remove the nth node from the end of the list and return its head.

//Follow up: Could you do this in one pass?
//Example 1:
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
//Example 2:
//Input: head = [1], n = 1
//Output: []
//Example 3:
//Input: head = [1,2], n = 1
//Output: [1]

public class RemoveFromEnd {
	static class Node {
		int data;
		Node next;

		Node() {

		}

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private static Node removeFromEnd(Node head, int end) {
		Node dummy = new Node();
		dummy.next = head;
		Node fast = head;
		for (int i = 0; i < end; i++) {
			fast = fast.next;
		}
		Node slow = dummy;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		Node result = removeFromEnd(head, 2);
		while (result != null) {
			System.out.print(result.data + "->");
			result = result.next;
		}
		System.out.print("null");
	}

}
