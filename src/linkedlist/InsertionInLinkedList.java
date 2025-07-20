package linkedlist;

public class InsertionInLinkedList {

	public static void main(String[] args) {
		ListNode headNode = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		headNode.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		ListNode newNode = new ListNode(10);
		ListNode result = insert(headNode, newNode, 1);
		while (result != null) {
			System.out.println(result.getData());
			result = result.getNext();
		}
	}

	private static ListNode insert(ListNode headNode, ListNode newNode, int position) {
		if (headNode == null) {
			return newNode;
		}
		int size = 0;
		ListNode current = headNode;
		while (current != null) {
			current = current.getNext();
			size++;
		}
		if (position > size + 1 || position < 1) {
			System.out.println("Not possible to insert");
			return headNode;
		}
		if (position == 1) {
			newNode.setNext(headNode);
			return newNode;
		} else {
			ListNode previousNode = headNode;
			int count = 1;
			while (count < position - 1) {
				count++;
				previousNode = previousNode.getNext();
			}
			ListNode temp = previousNode.getNext();
			newNode.setNext(temp);
			previousNode.setNext(newNode);
		}
		return headNode;
	}

}
