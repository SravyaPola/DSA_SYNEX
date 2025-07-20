package linkedlist;

public class DoublyLinkedList {

	static class Node {
		int val;
		Node next;
		Node prev;

		Node(int val) {
			this.val = val;
			this.next = null;
			this.prev = null;
		}
	}

	private Node head;
	private Node tail;

	public void insert(int val) {
		Node node = new Node(val);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail; 
			tail = node;
		}
	}

	public void printforward(Node root) {
		while (root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
	}

	public void printbackward(Node root) {
		while (root != null) {
			System.out.print(root.val + " ");
			root = root.prev;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		doublyLinkedList.insert(10);
		doublyLinkedList.insert(20);
		doublyLinkedList.insert(30);

		System.out.println("Forward list");
		doublyLinkedList.printforward(doublyLinkedList.head);

		System.out.println("\nReverse list");
		doublyLinkedList.printbackward(doublyLinkedList.tail);

	}
}