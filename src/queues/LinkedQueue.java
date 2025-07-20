package queues;

public class LinkedQueue {
	// simple node holding an int
	private static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	private Node front, rear; // front = head of list, rear = tail

	public LinkedQueue() {
		front = rear = null;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public void enQueue(int data) {
		Node node = new Node(data);
		if (rear == null) {
			// empty queue
			front = rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
	}

	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue empty");
			return -1;
		}
		int val = front.data;
		front = front.next;
		if (front == null) {
			// queue became empty
			rear = null;
		}
		return val;
	}

	// helper to dump contents without destructive dequeues
	public void printQueue() {
		Node cur = front;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedQueue q = new LinkedQueue();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.printQueue(); // 1 2 3

		System.out.println(q.deQueue());
		q.printQueue(); // 2 3

		q.enQueue(4);
		q.enQueue(5);
		q.printQueue(); // 2 3 4 5

		while (!q.isEmpty()) {
			System.out.print(q.deQueue() + " ");
		}
		System.out.println("\n" + q.isEmpty());
	}
}
