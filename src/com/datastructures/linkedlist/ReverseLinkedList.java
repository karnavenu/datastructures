package com.datastructures.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// LinkedList<LinkedListNode> linkedList = new
		// LinkedList<LinkedListNode>();
		//
		// LinkedListNode head = new LinkedListNode(1);
		// head.next = new LinkedListNode(2);
		// head.next.next = new LinkedListNode(3);
		// head.next.next.next = new LinkedListNode(4);
		// head.next.next.next.next = new LinkedListNode(5);
		// linkedList.add(head);
		// //
		// // linkedList.add(0,new LinkedListNode(1));
		// // linkedList.add(0,new LinkedListNode(2));
		// // linkedList.add(0,new LinkedListNode(3));
		// // linkedList.add(0,new LinkedListNode(4));
		// // linkedList.add(0, new LinkedListNode(5));
		//
		// for (LinkedListNode node : linkedList) {
		// System.out.println(node.data);
		// }
		// LinkedListNode head1 = linkedList.get(0);
		// reverseList(head1);
		// for (LinkedListNode node : linkedList) {
		// System.out.println(node.data);
		// }

		LinkedListImpl lList = new LinkedListImpl();

		// add elements to LinkedList
		lList.add("1");
		lList.add("2");
		lList.add("3");
		lList.add("4");
		lList.add("5");
		
		System.out.println("lList - print linkedlist: " + lList);
	    LinkedListNode newList = reverseList(lList.head.next);
	    lList.head.next = newList;
		System.out.println("lList - print linkedlist: " + lList);
	}
	
	

	public static LinkedListNode reverseList(LinkedListNode node) {
		LinkedListNode head = null;
		if(node == null){
			return node;
		}
		
		if(node.next == null){
			head = node;
			return head;
		}
		head = reverseList(node.next);
		node.next.next = node;
		node.next= null;
		return head;
	}

}
