package linkedlist;

//Given two linked lists sorted in increasing order.
//Merge them such a way that the result list is in decreasing order (reverse order).
//Examples:
//Input:  a: 5->10->15->40 b: 2->3->20
//Output: res: 40->20->15->10->5->3->2
//Input:  a: NULL b: 2->3->20
//Output: res: 20->3->2
public class MergeDecreasingOrder {
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

	private static Node merge(Node head1, Node head2) {
		Node result = null;
		while (head1 != null && head2 != null) {
			Node newNode;
			if (head1.data < head2.data) {
				newNode = new Node(head1.data);
				head1 = head1.next;
			} else {
				newNode = new Node(head2.data);
				head2 = head2.next;
			}
			newNode.next = result;
			result = newNode;
		}
		Node rest = head1 != null ? head1 : head2;
		while (rest != null) {
			Node newNode = new Node(rest.data);
			newNode.next = result;
			result = newNode;
			rest = rest.next;
		}
		return result;
	}

	public static void main(String[] args) {
		Node head1 = new Node(5);
		head1.next = new Node(10);
		head1.next.next = new Node(15);
		head1.next.next.next = new Node(40);

		Node head2 = new Node(2);
		head2.next = new Node(3);
		head2.next.next = new Node(20);

		Node result = merge(head1, head2);
		while (result != null) {
			System.out.print(result.data + "->");
			result = result.next;
		}
		System.out.print("null");
	}

}
