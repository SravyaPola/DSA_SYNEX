package assessment2;

//LC - 795
public class LinkedListProblem {

	static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		int left = 2;
		int right = 3;

		Node head = new Node(2);
		head.next = new Node(1);
		head.next.next = new Node(4);
		head.next.next.next = new Node(3);

		int subLists = (totalSubLists(head, left, right));
		System.out.println(subLists);

	}

	private static int totalSubLists(Node head, int left, int right) {
		Node current = head;
		int rightLength = 0;
		int leftLength = 0;
		int total = 0;
		while (current != null) {
			if (current.val <= right) {
				rightLength++;
			} else {
				rightLength = 0;
			}
			if (current.val <= left - 1) {
				leftLength++;
			} else {
				leftLength = 0;
			}
			total = total + rightLength - leftLength;
			current = current.next;
		}
		return total;
	}

}
