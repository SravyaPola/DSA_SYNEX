package trees;

public class LinkedBinaryTree {
	class Node {
		private Node left;
		private Node right;
		private Character data;

		Node(Character data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public Node create(Character[] arr, int i) {
		if (i < arr.length && arr[i] != null) {
			Node node = new Node(arr[i]);
			node.left = create(arr, 2 * i + 1);
			node.right = create(arr, 2 * i + 2);
			return node;
		}
		return null;
	}

	public Character get_left_child(Node node) {
		if (node != null && node.left != null) {
			return node.left.data;
		} else {
			return null;
		}
	}

	public Character get_right_child(Node node) {
		if (node != null && node.right != null) {
			return node.right.data;
		} else {
			return null;
		}
	}

	public void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	public void inorder(Node node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}

	public void postorder(Node node) {
		if (node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}

	public static void main(String[] args) {
		Character[] treeArray = { 'D', 'A', 'F', 'E', 'B', 'R', 'T', 'G', 'Q', null, null, 'V', null, 'J', 'L' };
		LinkedBinaryTree tree = new LinkedBinaryTree();
		Node root = tree.create(treeArray, 0);

		System.out.println("left child  : " + tree.get_left_child(root.left));
		System.out.println("right child : " + tree.get_right_child(root.right));

		System.out.print("Pre-order:   ");
		tree.preorder(root);
		System.out.println();

		System.out.print("In-order:    ");
		tree.inorder(root);
		System.out.println();

		System.out.print("Post-order:  ");
		tree.postorder(root);
		System.out.println();
	}
}
