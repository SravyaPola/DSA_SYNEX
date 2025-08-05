package queues;

import java.util.*;

//1)Given a queue with random elements, we need to sort it.
//We are not allowed to use extra space. The operations allowed on queue are :
//enqueue() : Adds an item to rear of queue.
//dequeue() : Removes an item from front of queue.
//isEmpty() : Checks if a queue is empty.
//Examples :
//Input : A queue with elements
//        11  5  4  21
//Output : Modified queue with
//         following elements
//        4 5 11 21
//Input : A queue with elements
//        3  2  1  2
//Output : Modified queue with
//         following elements
//        1 2 2 3

public class QueueReversal {

	private static void sortQueue(Queue<Integer> q) {
		int n = q.size();
		for (int i = 0; i < n; i++) {
			int unsorted = n - i;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				int curr = q.remove();
				if (j < unsorted) {
					min = Math.min(min, curr);
				}
				q.add(curr);
			}

			boolean removed = false;
			for (int j = 0; j < n; j++) {
				int v = q.remove();
				if (j < unsorted && v == min && !removed) {
					removed = true;
				} else {
					q.add(v);
				}
			}
			q.add(min);
		}
	}

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>(Arrays.asList(11, 5, 4, 21));
		sortQueue(q);
		System.out.println(q);

		q = new LinkedList<>(Arrays.asList(3, 2, 1, 2));
		sortQueue(q);
		System.out.println(q);
	}

}
