package io.codingchallenges.leetcode;

/**
 *  Write a program to  invert a binary tree
 *  
 *
 *  Input
 *  
  
 *   4	
   /   \
  2     7
 / \   / \
1   3 6   9


Output

	 4
   /   \
  7     2
 / \   / \
9   6 3   1

 *  
 *  
 * @author rajesh
 * 
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *
 */
public class InvertBinaryTree {

	public static void main(String[] args) {


	}

	public static TreeNode invertTree(TreeNode root) {
		
		return null;

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){
		
	}
	TreeNode(int val){
		this.val = val;
	}
	
	TreeNode(int val,TreeNode left, TreeNode right ){
		this.val = val;
		this.left =left;
		this.right = right;
	}

}

