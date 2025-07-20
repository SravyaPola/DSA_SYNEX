package linkedlist;

public class PalindromeLL {

	// check if a linked list is palindrome or not!
//	    eg1:
//		list={1,2,3,3,2,1}
//		output:palindrome
//		eg2:
//		list={1,2,3,2,1}
//		output: not palindrome

	private static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.getData() + "->");
			node = node.getNext();
		}
		System.out.print("null");
		System.out.println();
	}

	public static void main(String[] args) {
		// {1,2,3,3,2,1}
//		ListNode head = new ListNode(1);
//		head.setNext(new ListNode(2));
//		head.getNext().setNext(new ListNode(3));
//		head.getNext().getNext().setNext(new ListNode(3));
//		head.getNext().getNext().getNext().setNext(new ListNode(2));
//		head.getNext().getNext().getNext().getNext().setNext(new ListNode(1));
//		printList(head);

		// {1,2,3,2,1}
		ListNode head = new ListNode(1);
		head.setNext(new ListNode(2));
		head.getNext().setNext(new ListNode(3));
		head.getNext().getNext().setNext(new ListNode(4));
		head.getNext().getNext().getNext().setNext(new ListNode(5));
		printList(head);
		System.out.println(palindrome(head));

	}

	private static boolean palindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		ListNode middle = middle(head);
		printList(middle);
		ListNode reversed = reversal(middle.getNext());
		printList(reversed);
		while (reversed != null) {
			if (head.getData() != reversed.getData()) {
				return false;
			} else {
				head = head.getNext();
				reversed = reversed.getNext();
			}
		}
		return true;
	}

	private static ListNode reversal(ListNode head) {
		ListNode current = head;
		ListNode temp = null;
		while (current != null) {
			ListNode temp2 = current.getNext();
			current.setNext(temp);
			temp = current;
			current = temp2;
		}
		return temp;
	}

	// if odd, first half is having more nodes
	// if even, first and second half have equal nodes
	private static ListNode middle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return slow;
	}

}
