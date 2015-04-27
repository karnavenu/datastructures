package com.datastructures.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import com.datastructures.commom.AssortedMethods;
import com.datastructures.commom.TreeItem;
import com.datastructures.commom.TreeNode;
import com.datastructures.node.Node;

public class TravesalMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bst = new BinaryTree();
		bst.setRoot(5);
		int[] input = new int[] { 10, 3, 9, 7, 8, 2 };
		for (int i : input) {
			try {
				bst.insert(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// System.out.println("Is 9 in the  "
		// + (bfs(bst.getRoot(), 9) ? "Yes!" : "No."));
		//
		// System.out.println("Is 42 in the  "
		// + (bfs(bst.root, 42) ? "Yes!" : "No."));

		// ArrayList<LinkedList<Node>> result = findLevelLinkedList(bst.root);
		//
		// for (int i = 0; i < result.size(); i++) {
		// LinkedList<Node> levelList = result.get(i);
		// System.out.println("Level: "+i+"==Result:"+
		// levelList.getFirst().data+","+levelList.getLast().data);
		// }

		int[] nodes_flattened = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = findLevelLinkedList(root);
		printResult(list);
		
		ArrayList<LinkedList<TreeNode>> mirrorList = findLevelLinkedList(mirrorTreeView(root));
		printResult(mirrorList);
		
		
		ArrayList<Integer> rightResult = rightSideTreeView(root);
		printListResult("RightView",rightResult);
		

		ArrayList<Integer> rightMirrorResult = rightSideTreeView(mirrorTreeView(root));
		printListResult("MirrorRightView",rightMirrorResult);
		
		ArrayList<Integer> leftResult = leftSideTreeView(root);
		printListResult("LeftView",leftResult);		
		
		ArrayList<Integer> leftMirrorResult = leftSideTreeView(mirrorTreeView(root));
		printListResult("MirrorLeftView",leftMirrorResult);
		
		
		ArrayList<Integer> topResult = topTreeView(root);
		printListResult("TopView",topResult);
		
		HashMap<Integer, Integer> bottomResult = bottomTreeView(root);
		printMapResult("BottomView",bottomResult);
		
		

	}

	public static boolean dfs(Node root, int value) {
		// DFS uses Stack data structure
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		// printNode(rootNode);
		Node current = null;
		while (!stack.isEmpty()) {
			current = stack.pop();

			System.out.println(current.data);
			if (current.data == value) {
				return true;
			}

			if (current.right != null) {
				stack.push(current.right);
			}

			if (current.left != null) {
				stack.push(current.left);
			}

		}

		return false;
	}

	public static boolean bfs(Node root, int value) {
		// DFS uses Queue data structure
		QueueWithTwoStacks<Node> queue = new QueueWithTwoStacks<Node>();
		queue.enqueue(root);
		// printNode(rootNode);
		Node current = null;
		while (!queue.isEmpty()) {
			current = queue.dequeue();

			System.out.println(current.data);
			if (current.data == value) {
				return true;
			}

			if (current.left != null) {
				if (current.left.data == value) {
					return true;
				} else {
					queue.enqueue(current.left);
				}
			}

			if (current.right != null) {
				if (current.right.data == value) {
					return true;
				} else {
					queue.enqueue(current.right);
				}
			}
		}

		return false;
	}

	public static ArrayList<LinkedList<TreeNode>> findLevelLinkedList(
			TreeNode root) {
		int level = 0;
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

		list.add(root);
		result.add(level, list);

		while (true) {
			list = new LinkedList<TreeNode>();

			for (int i = 0; i < result.get(level).size(); i++) {
				TreeNode n = result.get(level).get(i);
				if (n != null) {
					if (n.left != null) {
						list.add(n.left);
					}
					if (n.right != null) {
						list.add(n.right);
					}
				}
			}

			if (list.size() > 0) {
				result.add(level + 1, list);
			} else {
				break;
			}

			level++;
		}

		return result;
	}

	public static void printResult(ArrayList<LinkedList<TreeNode>> result) {
		int depth = 0;
		for (LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while (i.hasNext()) {
				System.out.print(" " + ((TreeNode) i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	public static void printListResult(String name,ArrayList<Integer> result) {
		System.out.println(name+": ");
		for (int nodeValue : result) {
			System.out.print(nodeValue);
		}
		System.out.println();
	}
	
	public static void printMapResult(String name,HashMap<Integer,Integer> result) {
		System.out.println(name+": ");
		for (int nodeValue : result.values()) {
			System.out.print(nodeValue);
		}
		System.out.println();
	}

	public static ArrayList<Integer> leftSideTreeView(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		while (!list.isEmpty()) {
			int size = list.size();

			for (int i = 0; i < size; i++) {
				TreeNode top = list.remove();

				// the first element in the queue (right-most of the tree)
				if (i == 0) {
					result.add(top.data);
				}
				if (top.right != null) {
					list.add(top.right);
				}
				// add left
				if (top.left != null) {
					list.add(top.left);
				}
			}

		}
		return result;

	}
	
	public static ArrayList<Integer> rightSideTreeView(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		while (!list.isEmpty()) {
			int size = list.size();

			for (int i = 0; i < size; i++) {
				TreeNode top = list.remove();

				// the first element in the queue (right-most of the tree)
				if (i == 0) {
					result.add(top.data);
				}
				
				// add left
				if (top.left != null) {
					list.add(top.left);
				}
				if (top.right != null) {
					list.add(top.right);
				}
			}

		}
		return result;

	}
	
	public static ArrayList<Integer> topTreeView(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		LinkedList<TreeItem> list = new LinkedList<TreeItem>();
		HashSet<Integer> set = new HashSet<Integer>();
		list.add(new TreeItem(root,0));
		while (!list.isEmpty()) {
			
			TreeItem item = list.remove();
			int distance = item.distance;
			TreeNode node = item.node;
			
			if(!set.contains(distance)){
				set.add(distance);
				result.add(node.data);
			}
			
			if(node.left!=null){
				list.add(new TreeItem(node.left,distance-1));
			}
			if(node.right!=null){
				list.add(new TreeItem(node.right,distance+1));
			}
		}
		
		return result;
	}	
	
	
	public static HashMap<Integer,Integer> bottomTreeView(TreeNode root) {
		LinkedList<TreeItem> list = new LinkedList<TreeItem>();
		HashMap<Integer,Integer> result = new HashMap<Integer,Integer>();
		list.add(new TreeItem(root,0));
		while (!list.isEmpty()) {
			
			TreeItem item = list.remove();
			int distance = item.distance;
			TreeNode node = item.node;
			result.put(distance,node.data);
			
			if(node.left!=null){
				list.add(new TreeItem(node.left,distance-1));
			}
			if(node.right!=null){
				list.add(new TreeItem(node.right,distance+1));
			}
		}
		
		return result;
	}
	
	public static TreeNode mirrorTreeView(TreeNode root) {
		
		if(root==null){
			return root;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirrorTreeView(root.left);
		mirrorTreeView(root.right);
		
		return root;
	}

}
