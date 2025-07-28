package problems;

public class Problem_25 {
	public static int helper(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		}
		return helper(root.left, sum) + helper(root.right, sum);
	}

	public static TreeNode insert(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (val < root.val) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = null;
		int[] arr = { 10, 4, 6, 5, 9, 3, 12, 11, 16, 17 };
		for (int i : arr) {
			root = insert(root, i);
		}
		int sum = 0;
		sum = helper(root, sum);
		System.out.println(sum);
	}

}
