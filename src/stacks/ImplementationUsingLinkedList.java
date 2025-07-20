package stacks;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class ImplementationUsingLinkedList {

	private Node head;

	ImplementationUsingLinkedList() {
		this.head = null;
	}

	public void push(int val) {
		if (head == null) {
			head = new Node(val);
		} else {
			Node newNode = new Node(val);
			newNode.next = head;
			head = newNode;
		}
	}

	public int pop() {
		if (head == null) {
			System.out.print("Stack is Empty");
			return -1;
		} else {
			int data = head.data;
			head = head.next;
			return data;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void printStack() {
		Node curr = head;
		System.out.print("Stack contents (top → bottom): ");
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ImplementationUsingLinkedList iul = new ImplementationUsingLinkedList();
		iul.push(10);
		iul.push(20);
		iul.push(30);
		iul.printStack();
		System.out.println("Popped element: " + iul.pop());
		iul.printStack();
		System.out.println("Is stack empty? " + iul.isEmpty());
	}

}
