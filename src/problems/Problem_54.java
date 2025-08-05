package problems;

import java.util.*;
//1)create a tree from postorder= {9,1,2,12,7,5,3,11,4,8}; and
//inorder = {9,5,1,7,2,12,8,4,3,11};

//2)create a tree from  preorder = {1,2,4,8,9,10,11,5,3,6,7}; and     
//inorder = {8,4,10,9,11,2,5,1,6,3,7};

//3)CREATE TREE FROM Preorder : F,B,A,D,C,E,G,I,H
//Postorder :A,C,E,D,B,H,I,G,F

public class Problem_54 {

	public static TreeNode buildFromPostAndIn(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart,
			int inEnd, Map<Integer, Integer> inMap) {
		if (postStart > postEnd || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postEnd]);

		int inRoot = inMap.get(root.val);
		int numsLeft = inRoot - inStart;

		root.left = buildFromPostAndIn(postorder, postStart, postStart + numsLeft - 1, inorder, inStart, inRoot - 1,
				inMap);
		root.right = buildFromPostAndIn(postorder, postStart + numsLeft, postEnd - 1, inorder, inRoot + 1, inEnd,
				inMap);

		return root;
	}

	public static TreeNode buildFromPreAndIn(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
			int inEnd, Map<Integer, Integer> inMap) {

		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);

		int inRoot = inMap.get(root.val);
		int numsLeft = inRoot - inStart;

		root.left = buildFromPreAndIn(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
		root.right = buildFromPreAndIn(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
		return root;
	}

	public static List<List<Integer>> print(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> sublist = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				if (temp != null) {
					if (temp.left != null) {
						q.add(temp.left);
					}
					if (temp.right != null) {
						q.add(temp.right);
					}
					sublist.add(temp.val);
				}
			}
			result.add(sublist);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] postorder1 = { 9, 1, 2, 12, 7, 5, 3, 11, 4, 8 };
		int[] inorder1 = { 9, 5, 1, 7, 2, 12, 8, 4, 3, 11 };

		Map<Integer, Integer> inMap1 = new HashMap<>();

		for (int i = 0; i < inorder1.length; i++) {
			inMap1.put(inorder1[i], i);
		}

		TreeNode result1 = buildFromPostAndIn(postorder1, 0, postorder1.length - 1, inorder1, 0, inorder1.length - 1,
				inMap1);

		System.out.println(print(result1));

		int[] preorder2 = { 1, 2, 4, 8, 9, 10, 11, 5, 3, 6, 7 };
		int[] inorder2 = { 8, 4, 10, 9, 11, 2, 5, 1, 6, 3, 7 };

		Map<Integer, Integer> inMap2 = new HashMap<>();

		for (int i = 0; i < inorder2.length; i++) {
			inMap2.put(inorder2[i], i);
		}

		TreeNode result2 = buildFromPreAndIn(preorder2, 0, preorder2.length - 1, inorder2, 0, inorder2.length - 1,
				inMap2);

		System.out.println(print(result2));
	}

}
