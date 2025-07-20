package queues;

import java.util.Stack;

//Given an integer k and a queue of integers, we need to reverse the order of the first k elements of the queue,
//leaving the other elements in the same relative order.
//Only following standard operations are allowed on queue.
//enqueue(x) : Add an item x to rear of queue
//dequeue() : Remove an item from front of queue
//size() : Returns number of elements in queue.
//front() : Finds front item.
//Examples:
//Input : Q = [10, 20, 30, 40, 50, 60,  70, 80, 90, 100] k = 5
//Output : Q = [50, 40, 30, 20, 10, 60, 70, 80, 90, 100]
//Input : Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100] k = 4
//Output : Q = [40, 30, 20, 10, 50, 60, 70, 80, 90, 100]
//The idea is to use an auxiliary stack.

public class ReverseKElementsInQueueFromFront {
	static class queue {
		private int front;
		private int rear;
		private int capacity;
		private int size;
		private int[] array;

		queue() {

		}

		queue(int capacity) {
			this.front = -1;
			this.rear = -1;
			this.capacity = capacity;
			this.array = new int[capacity];
			this.size = 0;
		}

		private boolean isFull() {
			return (rear + 1) % capacity == front;
		}

		private boolean isEmpty() {
			return front == -1;
		}

		private void enQueue(int data) {
			if (isFull()) {
				System.out.println("Queue full");
			} else {
				rear = (rear + 1) % capacity;
				array[rear] = data;
				if (front == -1) {
					front = rear;
				}
				size++;
			}
		}

		private int deQueue() {
			int data = -1;
			if (isEmpty()) {
				System.out.println("Queue Empty");
			} else {
				data = array[front];
				if (front == rear) {
					front = rear = -1;
				} else {
					front = (front + 1) % capacity;
				}
				size--;
			}
			return data;
		}

		private int size() {
			return size;
		}

		private int front() {
			return array[front];
		}
	}

	private static queue reverseKElements(queue q, int k) {
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < k; i++) {
			stk.push(q.deQueue());
		}
		System.out.println("size : " + q.size());
		System.out.println("front : " + q.front());
		print(q);
		while (!stk.isEmpty()) {
			q.enQueue(stk.pop());
		}
		System.out.println("size : " + q.size());
		System.out.println("front : " + q.front());
		print(q);
		for (int i = 0; i < q.capacity - k; i++) {
			q.enQueue(q.deQueue());
		}
		System.out.println("size : " + q.size());
		System.out.println("front : " + q.front());
		return q;
	}

	public static void main(String[] main) {
		queue q = new queue(10);
		q.enQueue(10);
		q.enQueue(20);
		q.enQueue(30);
		q.enQueue(40);
		q.enQueue(50);
		q.enQueue(60);
		q.enQueue(70);
		q.enQueue(80);
		q.enQueue(90);
		q.enQueue(100);
		queue result = reverseKElements(q, 4);
		print(result);
	}

	private static void print(queue result) {
		System.out.print("Output : ");
		for (int a : result.array) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

}
