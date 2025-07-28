package binarysearchtrees;

import java.util.*;

class Node {
	int val;
	Node left;
	Node right;

	Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class InsertionAndDeletionInBST {
	Node root;

	public void insert(int val) {
		Node newNode = new Node(val);
		// if tree is empty, newNode is root
		if (root == null) {
			root = newNode;
			return;
		}
		// search for the insertion point
		Node current = root;
		Node prev = null;
		while (current != null) {
			prev = current;
			if (val < current.val) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		// 4) Attach newNode as the correct child of prev
		if (val < prev.val) {
			prev.left = newNode;
		} else {
			prev.right = newNode;
		}
	}

	public void delete(int val) {
		Node current = root;
		Node prev = null;
		// Search for the node to delete, tracking its prev
		while (current != null && current.val != val) {
			prev = current;
			if (val < current.val) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		// val not found;
		if (current == null) {
			return;
		}
		// If it has two children, replace its value with
		// its in-order successor, then delete that successor
		if (current.left != null && current.right != null) {
			Node succParent = current;
			Node successor = current.right;
			// Find leftmost node in right subtree
			while (successor.left != null) {
				succParent = successor;
				successor = successor.left;
			}
			// Copy successor’s value into current node
			current.val = successor.val;
			// Move the prev and current to succParent and successor, so that the below code
			// for fall through will take care
			prev = succParent;
			current = successor;
			// FALL-THROUGH to the splice-out logic below
			// At this point:
			// Case - 1
			// - successor.left == null (by findMin)
			// - successor.right == null (if it was a leaf successor)
			// Case - 2
			// If successor.right != null then splice-out handles the 1-child case.
		}
		// At this point, current has at most one child.
		// Splice it out by hooking that child up to prev.
		Node child = (current.left != null) ? current.left : current.right;
		// If deleting the root, reset root pointer
		if (prev == null) {
			root = child;
			// Otherwise, hook child into the correct side of prev
		} else if (prev.left == current) {
			prev.left = child;
		} else {
			prev.right = child;
		}
	}

	public List<Integer> inorder() {
		List<Integer> result = new ArrayList<>();
		inorderRecursive(root, result);
		return result;
	}

	private void inorderRecursive(Node node, List<Integer> list) {
		if (node == null)
			return;
		inorderRecursive(node.left, list);
		list.add(node.val);
		inorderRecursive(node.right, list);

	}

	public static void main(String[] args) {
		InsertionAndDeletionInBST bst = new InsertionAndDeletionInBST();

		int[] arr = { 52, 36, 38, 68, 24, 23, 27, 26, 59, 60, 72, 70, 80, 75, 76 };

		for (int x : arr) {
			bst.insert(x);
		}
		// bst.insert(39);
		System.out.println("After Insertion: " + bst.inorder());
		bst.delete(23); // leaf
		System.out.println("After Deletion: " + bst.inorder());
		bst.delete(59); // one child
		System.out.println("After Deletion: " + bst.inorder());
		bst.delete(24);
		// The In order traversal of binary search tree is itself the the sorted array
		System.out.println("After Deletion: " + bst.inorder());
	}

}
