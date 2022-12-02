package com.codingtest.tree;

/**
 * 이진트리 순회 프로그램
 * @author : crtEvent
 * @date   : 2022. 12. 2.
 */
public class LinkedBinaryTreeTraversal {
	
	public TreeNode makeBinaryTree(TreeNode bt1, Object data, TreeNode bt2) {
		TreeNode root = new TreeNode();
		root.data = data;
		root.left = bt1;
		root.right = bt2;
		return root;
	}
	
	public void preorder(TreeNode root) {
		if(root != null) {
			System.out.printf("%s ", root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void inorder(TreeNode root) {
		if(root != null) {
			inorder(root.left);
			System.out.printf("%s ", root.data);
			inorder(root.right);
		}
	}
	
	public void postorder(TreeNode root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.printf("%s ", root.data);
		}
	}
	
	public static void main(String[] args) {
		LinkedBinaryTreeTraversal T = new LinkedBinaryTreeTraversal();
		
		/*        n1
		 *      /    \
		 *    n2	  n3
		 *   /  \    /  \
		 *  n4	n5	n6	n7
		 */
		
		TreeNode n7 = T.makeBinaryTree(null, "n7", null);
		TreeNode n6 = T.makeBinaryTree(null, "n6", null);
		TreeNode n5 = T.makeBinaryTree(null, "n5", null);
		TreeNode n4 = T.makeBinaryTree(null, "n4", null);
		TreeNode n3 = T.makeBinaryTree(n6, "n3", n7);
		TreeNode n2 = T.makeBinaryTree(n4, "n2", n5);
		TreeNode n1 = T.makeBinaryTree(n2, "n1", n3);
		
		System.out.println("Preorder(전위 순회)");
		System.out.println("현재 노드 n -> n의 왼쪽 서브트리 -> n의 오른쪽 서브트리");
		T.preorder(n1);
		System.out.println("\n");
		
		System.out.println("Inorder(중위 순회)");
		System.out.println("n의 왼쪽 서브트리 -> 현재 노드 n -> n의 오른쪽 서브트리");
		T.inorder(n1);
		System.out.println("\n");
		
		System.out.println("Postorder(후위 순회)");
		System.out.println("n의 왼쪽 서브트리 -> n의 오른쪽 서브트리 -> 현재 노드 n");
		T.postorder(n1);
		System.out.println("\n");
		
	}
}
