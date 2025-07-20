package linkedlist;

public class DeletionInLinkedList {
	public static void main(String[] args) {
		ListNode headNode = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		headNode.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		ListNode result = delete(headNode, 0);
		while (result != null) {
			System.out.println(result.getData());
			result = result.getNext();
		}
	}

	private static ListNode delete(ListNode headNode, int position) {
		if (headNode == null) {
			return null;
		}
		int size = 0;
		ListNode current = headNode;
		while (current != null) {
			current = current.getNext();
			size++;
		}
		if (position > size || position < 1) {
			System.out.println("Cannot delete");
			return headNode;
		}
		if (position == 1) {
			ListNode currentNode = headNode.getNext();
			headNode = null;
			return currentNode;
		} else {
			ListNode previousNode = headNode;
			int count = 1;
			while(count < position - 1) {
				previousNode = previousNode.getNext();
				count++;
			}
			ListNode temp = previousNode.getNext();
			previousNode.setNext(temp.getNext());
			temp = null;
		}
		return headNode;
	}
}
