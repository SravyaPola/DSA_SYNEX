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

public class SortAQueueInPlace {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(11);
		q.add(5);
		q.add(4);
		q.add(21);
		sort(q);
		System.out.println(q);
	}
	private static void sort(Queue<Integer> q) {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			if(i < 0) {
			}
		}
	}

}
