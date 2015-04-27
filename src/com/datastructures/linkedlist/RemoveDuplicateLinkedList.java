package com.datastructures.linkedlist;

import java.util.HashMap;

public class RemoveDuplicateLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private void deleteDuplicates(LinkedListNode head){
		
		HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		LinkedListNode previousNode = null;
		
		while(head!=null){
			if(map.containsKey(head.data)){
				previousNode.next = head.next;
			}else{
				map.put(head.data, true);
				previousNode = head;
			}
			head=head.next;
			
		}
		
	}
	
	private LinkedListNode nthLatElement(LinkedListNode head,int n){
		if(head==null || n<1){
			return null;
		}
		
		LinkedListNode firstRunner=head;
		LinkedListNode secondRunner = head;
		
		for(int j=0;j<n-1;j++){
			if(firstRunner == null){
				return null;
			}
			firstRunner = head.next;
		}
		
		while(firstRunner!=null){
			firstRunner = firstRunner.next;
			secondRunner = secondRunner.next;
		}
		return secondRunner;
	}

}
