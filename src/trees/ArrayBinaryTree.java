package trees;

//On the binary tree array implementation write the following methods:
//tree = [ 'D', 'A', 'F', 'E', 'B', 'R', 'T', 'G', 'Q', None, None, 'V', None, 'J', 'L']
//get_right_child(index)
//get_left_child(index)
//get_parent(index)
//preorder(index)
//inorder(index)
//postorder(index)

public class ArrayBinaryTree {
	private Character[] tree;
	private int size;

	ArrayBinaryTree(Character[] tree) {
		this.tree = tree;
		this.size = tree.length;
	}

	private Character get_right_child(int i) {
		int right = 2 * i + 2;
		if (right < 0 || right >= size) {
			System.out.println("No right child");
			return null;
		}
		return tree[right];
	}

	private Character get_left_child(int i) {
		int left = 2 * i + 1;
		if (left < 0 || left >= size) {
			System.out.println("No left child");
			return null;
		}
		return tree[left];
	}

	private Character get_parent(int i) {
		if (i <= 0 || i >= size) {
			System.out.println("No parent");
			return null;
		}
		int parent = (i - 1) / 2;
		return tree[parent];
	}

	private void preorder(int i) {
		if (i >= size || tree[i] == null) {
			return;
		}
		System.out.print(tree[i] + " ");
		preorder(2 * i + 1);
		preorder(2 * i + 2);
	}

	private void inorder(int i) {
		if (i >= size || tree[i] == null) {
			return;
		}
		inorder(2 * i + 1);
		System.out.print(tree[i] + " ");
		inorder(2 * i + 2);
	}

	private void postorder(int i) {
		if (i >= size || tree[i] == null) {
			return;
		}
		postorder(2 * i + 1);
		postorder(2 * i + 2);
		System.out.print(tree[i] + " ");
	}

	public static void main(String[] args) {
		Character[] treeArray = new Character[] { 'D', 'A', 'F', 'E', 'B', 'R', 'T', 'G', 'Q', null, null, 'V', null,
				'J', 'L' };
		ArrayBinaryTree tree = new ArrayBinaryTree(treeArray);

		System.out.println("left child  : " + tree.get_left_child(0));
		System.out.println("right child : " + tree.get_right_child(0));
		System.out.println("parent      : " + tree.get_parent(1));

		System.out.print("Pre-order:   ");
		tree.preorder(0);
		System.out.println();

		System.out.print("In-order:    ");
		tree.inorder(0);
		System.out.println();

		System.out.print("Post-order:  ");
		tree.postorder(0);
		System.out.println();
	}

}
