package queues;

// Circular Queue 
public class CircularQueue {
	private int front;
	private int rear;
	private int capacity;
	private int[] array;

	private CircularQueue(int size) {
		capacity = size;
		front = -1;
		rear = -1;
		array = new int[size];
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public boolean isFull() {
		return (rear + 1) % capacity == front;
	}

	public void enQueue(int data) {
		if (isFull()) {
			System.out.println("Queue full");
		} else {
			rear = (rear + 1) % capacity;
			array[rear] = data;
			if (front == -1) {
				front = rear;
			}
		}
	}

	public int deQueue() {
		int data = -1;
		if (isEmpty()) {
			System.out.println("Queue empty");
		} else {
			data = array[front];
			if (front == rear) {
				front = rear = -1;
			} else {
				front = (front + 1) % capacity;
			}
		}
		return data;
	}

	public static void main(String[] args) {
		CircularQueue q = new CircularQueue(5);
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		print(q.array);
		System.out.println(q.isFull());
		q.enQueue(6);

		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		q.enQueue(6);
		q.enQueue(7);
		print(q.array);
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.isEmpty());
		print(q.array);
		q.enQueue(8);
		print(q.array);
	}

	private static void print(int[] array) {
		for (int a : array) {
			System.out.print(a);
		}
		System.out.println();
	}

//Dequeue cost
//
//Plain array + shift: O(n) per deQueue() because of the for-loop.
//
//Circular array: O(1) by moving a front index with % capacity.
//
//Space reuse
//
//Plain array: after many dequeues you’ll only ever use the prefix of the array; 
//the tail slots stay unused unless you shift.
//
//Circular array: automatically recycles freed slots without shifting.
}