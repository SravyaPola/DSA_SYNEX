package linkedlist;

public class SortedLLWithoutDuplicates {

//	WAP to create a singly linked list from  unsorted array ,the resultant  list is in sorted order and does not contain any  duplicate values .
//	Example1:
//	input:int[] arr= {1, 2, 2, 0,2,0, 3, 4, 4,3, 5};
//	output:{0,1,2,3,4,5}
//	Example 2:
//	Input :int[] arr = {24,27,30,24,12,17,27,1,5,1,3};
//	output:{1, 3, 5, 12, 17, 24, 27,30}
//	Note: do it without sorting the array

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 2, 0, 2, 0, 3, 4, 4, 3, 5 };
		ListNode result1 = insertSorted(array1);
		while (result1 != null) {
			System.out.print(result1.getData() + "-->");
			result1 = result1.getNext();
		}
		System.out.print("null");
		System.out.println();
		int[] array2 = { 24, 27, 30, 24, 12, 17, 27, 1, 5, 1, 3 };
		ListNode result2 = insertSorted(array2);
		while (result2 != null) {
			System.out.print(result2.getData() + "-->");
			result2 = result2.getNext();
		}
		System.out.print("null");
		System.out.println();
	}

	private static ListNode insertSorted(int[] arr) {
		ListNode head = null;
		for (int a : arr) {
			head = helperMain(head, a);
		}
		return head;
	}

	private static ListNode helperMain(ListNode head, int val) {
		ListNode newNode = new ListNode(val);
		if (head == null) {
			return newNode;
		}
		if (val < head.getData()) {// insert at start if the val is less than head
			newNode.setNext(head);
			return newNode;
		}
		if (val == head.getData()) {// avoid duplicates
			return head;
		}
		ListNode current = head;
		// Traverse upto the place where you need to insert
		while (current.getNext() != null && current.getNext().getData() < val) {
			current = current.getNext();
		}
		if (current.getNext() != null && current.getNext().getData() == val) {// avoid duplicates
			return head;
		} else {
			ListNode temp = current.getNext();
			current.setNext(newNode);
			newNode.setNext(temp);
			return head;
		}
	}
}
