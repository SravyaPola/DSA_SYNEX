package avltrees;

public class InsertionInAVLTree {

	class Node {
		int val;
		Node left, right;
		int height;

		Node(int key) {
			this.val = key;
			this.height = 1;
		}
	}

	private Node root;

	public void insert(int key) {
		root = insert(root, key);
	}

	private Node insert(Node node, int key) {
		if (node == null) {
			return new Node(key);
		}
		if (key < node.val) {
			node.left = insert(node.left, key);
		} else if (key > node.val) {
			node.right = insert(node.right, key);
		} else {
			return node;
		}

		node.height = 1 + Math.max(height(node.left), height(node.right));

		int bf = getBalanceFactor(node);

		if (bf > 1 && key < node.left.val) {
			return rotateRight(node);
		}

		if (bf < -1 && key > node.right.val) {
			return rotateLeft(node);
		}

		if (bf > 1 && key > node.left.val) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}

		if (bf < -1 && key < node.right.val) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;
	}

	private Node rotateLeft(Node x) {
		Node y = x.right;
		Node rest = y.left;

		y.left = x;
		x.right = rest;

		x.height = 1 + Math.max(height(x.left), height(x.right));
		y.height = 1 + Math.max(height(y.left), height(y.right));

		return y;
	}

	private Node rotateRight(Node y) {
		Node x = y.left;
		Node rest = x.right;

		x.right = y;
		y.left = rest;

		y.height = 1 + Math.max(height(y.left), height(y.right));
		x.height = 1 + Math.max(height(x.left), height(x.right));

		return x;
	}

	private int height(Node n) {
		return n == null ? 0 : n.height;
	}

	private int getBalanceFactor(Node n) {
		return (n == null) ? 0 : height(n.left) - height(n.right);
	}

	public void inOrder() {
		inOrder(root);
		System.out.println();
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		}
	}

	public static void main(String[] args) {

		InsertionInAVLTree avlTree = new InsertionInAVLTree();

		int[] keys = { 50, 40, 30, 60, 55, 80, 10, 35, 32 };
		
		//int[] keys = { -10, -3, 0, 5, 9 };
		for (int key : keys) {
			avlTree.insert(key);
		}

		avlTree.inOrder();

	}

}
