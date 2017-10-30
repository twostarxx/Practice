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
	 * ǰ�������Ҫ˼�룺
	 * �Ӹ��ڵ��������������������������û������ֱ�ӷ��ʣ�������ǿ��Һ���ѹջ��
	 * ��������������ɣ���ջ�������Һ��ӽڵ㣬���������ýڵ����������*/
	/**
	 *ǰ��������ݹ�*/
	public static void preOrderRec(Node root) {
		if (root != null) {
			System.out.println(root.value);
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}
	/**
	 * ǰ��������ǵݹ�*/
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
	 * ����������ݹ�*/
	public static void inOrderRec(Node root) {
		if (root != null) {
			inOrderRec(root.left);
			System.out.println(root.value);
			inOrderRec(root.right);
		}
	}
	/**
	 * ����������ǵݹ�*/
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
	 * ����������ݹ�*/
	public static void postOrderRec(Node root) {
		if (root != null) {
			postOrderRec(root.left);
			postOrderRec(root.right);
			System.out.println(root.value);
		}
	}
	/**
	 * ����������ǵݹ�
	 * ���������Ҫ�ȴ�������������Ȼ����������ݣ���������Ҫһ����¼��Щ���Ѿ������ʵĽṹ��
	 * �˴�ʹ���м�ջ�洢��*/
	public static void postOrderRec2(Node root) {
		Stack<Node> s = new Stack<Node>();
		Stack<Node> o = new Stack<Node>();
		Node temp = root;
		while (! s.empty()) {
			if (temp != null) {
				o.push(temp);	//��ѹ���ڵ㣬����������
				s.push(temp);
				temp = temp.right;
			} else {
				//û�����ӽڵ㣬�滻�ɸ��ڵ����ڵ�
				temp = s.pop();
				temp = temp.left;
			}
		}
		while (! o.isEmpty()) {
			System.out.println(o.pop().value);
		}
	}
	
	/**
	 * ��α�������˼�룺
	 * ���Ƚ����ڵ���ӣ�Ȼ��ÿ�δӶ�����ȡ������Ԫ�ؽ��д���
	 * ÿ����һ���ڵ㣬�����ȷ��ʸýڵ㣬�ٰ������ҵ�˳������ĺ��ӽڵ�������ԡ�*/
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
