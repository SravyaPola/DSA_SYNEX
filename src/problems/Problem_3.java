package problems;

public class Problem_3 {

	private static ListNode mergeSortedList(ListNode l1, ListNode l2) {
		ListNode list1 = sortList(l1);
		ListNode list2 = sortList(l2);
		ListNode dummy = new ListNode();
		ListNode result = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				dummy.next = list1;
				list1 = list1.next;
				dummy = dummy.next;
			} else {
				dummy.next = list2;
				list2 = list2.next;
				dummy = dummy.next;
			}
		}
		dummy.next = (list1 != null) ? list1 : list2;
		return result.next;
	}

	private static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = getMid(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);
		return merge(left, right);
	}

	private static ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode();
		ListNode tail = dummy;
		while (left != null && right != null) {
			if (left.val < right.val) {
				tail.next = left;
				left = left.next;
				tail = tail.next;
			} else {
				tail.next = right;
				right = right.next;
				tail = tail.next;
			}
		}
		tail.next = (left != null) ? left : right;
		return dummy.next;
	}

	// if odd, first half is having more nodes
	// if even, first and second half have equal nodes
	private static ListNode getMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow.next; // second half is slow's next
		slow.next = null;// head is chopped off --- first half's last node is null
		return mid; // second half
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(1);
		l1.next.next = new ListNode(5);

		ListNode l2 = new ListNode(6);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(4);

		ListNode result = mergeSortedList(l1, l2);
		while (result != null) {
			System.out.print(result.val);
			System.out.print("-->");
			result = result.next;
		}
		System.out.print("null");
	}

}
