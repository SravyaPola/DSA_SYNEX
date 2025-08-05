package binarysearchtrees;

public class HeightOfBST {
	public int maxHeight(Node root) {
		if (root == null) {
			return 0;
		}
		int left = maxHeight(root.left);
		int right = maxHeight(root.right);
		return 1 + Math.max(left, right);
	}

	private static Node insert(Node root, int key) {
		if (root == null) {
			return new Node(key);
		}
		if (key < root.val) {
			root.left = insert(root.left, key);
		} else if (key > root.val) {
			root.right = insert(root.right, key);
		}
		return root;
	}

	public static void main(String[] args) {
		HeightOfBST tree = new HeightOfBST();
		int[] keys = { 50, 40, 30, 60, 55, 80, 10, 35, 32 };
		Node root = null;
		for (int key : keys) {
			root = insert(root, key);
		}
		int height = tree.maxHeight(root);
		System.out.println("Height of the BST is: " + height);
	}
}
