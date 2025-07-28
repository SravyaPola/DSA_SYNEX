package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_24 {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> ls = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.remove();
				if (temp != null) {
					ls.add(temp.val);
					if (temp.left != null) {
						q.add(temp.left);
					}
					if (temp.right != null) {
						q.add(temp.right);
					}
				}
			}
			result.add(ls);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.left.left = null;
		root.left.right = null;
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(zigzagLevelOrder(root));
	}

}
