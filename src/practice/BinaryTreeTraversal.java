package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	public int value;
	public Node left;
	public Node right;
	public Node(int v) {
		this.value = v;
		this.left = null;
		this.right = null;
	}
}

public class BinaryTreeTraversal {
	
	/*
	 * 前序遍历主要思想：
	 * 从根节点出发，沿着左子树向下搜索，没搜索到直接访问，并将其非空右孩子压栈。
	 * 当左子树访问完成，从栈顶弹出右孩子节点，进而遍历该节点的右子树。*/
	/**
	 *前序遍历，递归*/
	public static void preOrderRec(Node root) {
		if (root != null) {
			System.out.println(root.value);
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}
	/**
	 * 前序遍历，非递归*/
	public static void preOrderRec2(Node root) {
		if (root == null)
			return ;
		Stack<Node> s = new Stack<Node>();
		Node temp = root;
		while (!s.empty()) {
			if (temp != null) {
				System.out.println(temp.value);
				s.push(temp);
				temp = temp.left;
			} else {
				temp = s.pop();
				temp = temp.right;
			}
		}
	}
	
	/**
	 * 中序遍历，递归*/
	public static void inOrderRec(Node root) {
		if (root != null) {
			inOrderRec(root.left);
			System.out.println(root.value);
			inOrderRec(root.right);
		}
	}
	/**
	 * 中序遍历，非递归*/
	public static void inOrderRec2(Node root) {
		if (root == null)
			return ;
		Stack<Node> s = new Stack<Node>();
		Node temp = root;
		while(! s.empty()) {
			if (temp != null) {
				s.push(temp);
				temp = temp.left;
			} else {
				temp = s.pop();
				System.out.println(temp.value);
				temp = temp.right;
			}
		}
	}
	
	/**
	 * 后序遍历，递归*/
	public static void postOrderRec(Node root) {
		if (root != null) {
			postOrderRec(root.left);
			postOrderRec(root.right);
			System.out.println(root.value);
		}
	}
	/**
	 * 后序遍历，非递归
	 * 后序遍历需要先处理左右子树，然后处理根（回溯），所以需要一个记录哪些点已经被访问的结构。
	 * 此处使用中间栈存储。*/
	public static void postOrderRec2(Node root) {
		Stack<Node> s = new Stack<Node>();
		Stack<Node> o = new Stack<Node>();
		Node temp = root;
		while (! s.empty()) {
			if (temp != null) {
				o.push(temp);	//先压根节点，输出才是最后
				s.push(temp);
				temp = temp.right;
			} else {
				//没有右子节点，替换成根节点的左节点
				temp = s.pop();
				temp = temp.left;
			}
		}
		while (! o.isEmpty()) {
			System.out.println(o.pop().value);
		}
	}
	
	/**
	 * 层次遍历基本思想：
	 * 首先将根节点入队，然后每次从队列中取出对首元素进行处理。
	 * 每处理一个节点，都是先访问该节点，再按从左到右的顺序把它的孩子节点依次入对。*/
	public static void levelRec(Node root) {
		Queue<Node> q = new LinkedList<>();
		while (! q.isEmpty()) {
			Node temp = q.poll();
			System.out.println(temp.value);
			if (temp.left != null) 
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
	}
}
