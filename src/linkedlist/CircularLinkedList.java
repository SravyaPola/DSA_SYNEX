package linkedlist;

public class CircularLinkedList {

	class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}

	private Node head;
	private Node tail;

	public void insert(int val) {
		Node node = new Node(val);
		if (head == null) {
			head = node;
			tail = node;
			tail.next = head;
		} else {
			tail.next = node;
			tail = node;
			tail.next = head; 
		}
	}

	public void printCircularList() {
		if (head == null)
			return;
		for (Node n = head; n.next != head; n = n.next) {
			System.out.print(n.val + "->");
		}
		System.out.println(tail.val + "->" + tail.next.val + " -The circled back");
	}

	public static void main(String[] args) {
		CircularLinkedList circularLinkedList = new CircularLinkedList();
		circularLinkedList.insert(10);
		circularLinkedList.insert(20);
		circularLinkedList.insert(30);

		System.out.println("Circular Linked list");
		circularLinkedList.printCircularList();

	}
}
