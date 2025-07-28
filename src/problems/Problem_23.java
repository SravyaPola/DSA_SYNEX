package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {

	}

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class Problem_23 {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		boolean flag = false;
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> ls = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.remove();
				if (temp != null) {
					if (flag) {
						ls.add(0, temp.val);
					} else {
						ls.add(temp.val);
					}
					if (temp.left != null) {
						q.add(temp.left);
					}
					if (temp.right != null) {
						q.add(temp.right);
					}
				}
			}
			result.add(ls);
			flag = !flag;
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println(zigzagLevelOrder(root));
	}

}
