package linkedlist;

//Given a singly linked list, write a function to swap elements pairwise.
//Input : 1->2->3->4->5->6->NULL
//Output : 2->1->4->3->6->5->NULL
//Input : 1->2->3->4->5->NULL
//Output : 2->1->4->3->5->NULL
//Input : 1->NULL
//Output : 1->NULL

public class PairwiseSwap {
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

	private static Node swap(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node dummy = new Node(-1);
		dummy.next = head;
		Node prev = dummy;

		while (prev.next != null && prev.next.next != null) {
			Node first = prev.next;
			Node second = first.next;
			first.next = second.next;
			prev.next = second;
			second.next = first;
			prev = first;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		//head.next.next.next.next.next = new Node(6);

		Node result = swap(head);
		while (result != null) {
			System.out.print(result.data + "->");
			result = result.next;
		}
		System.out.print("null");
	}

}
