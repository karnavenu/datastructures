package com.datastructures.linkedlist;


public class LinkedListImpl {
    // reference to the head node.
    public LinkedListNode head;
    private int listCount;
 
    // LinkedList constructor
    public LinkedListImpl() {
        // this is an empty list, so the reference to the head node
        // is set to a new node with no data
        head = new LinkedListNode(0);
        listCount = 0;
    }
 
    public void add(Object data)
    // appends the specified element to the end of this list.
    {
    	LinkedListNode linkedListImplTemp = new LinkedListNode(data);
    	LinkedListNode linkedListImplCurrent = head;
        // starting at the head node, crawl to the end of the list
        while (linkedListImplCurrent.getNext() != null) {
            linkedListImplCurrent = linkedListImplCurrent.getNext();
        }
        // the last node's "next" reference set to our new node
        linkedListImplCurrent.setNext(linkedListImplTemp);
        listCount++;// increment the number of elements variable
    }
 
    public void add(Object data, int index)
    // inserts the specified element at the specified position in this list
    {
    	LinkedListNode linkedListImplTemp = new LinkedListNode(data);
    	LinkedListNode linkedListImplCurrent = head;
        // crawl to the requested index or the last element in the list,
        // whichever comes first
        for (int i = 1; i < index && linkedListImplCurrent.getNext() != null; i++) {
            linkedListImplCurrent = linkedListImplCurrent.getNext();
        }
        // set the new node's next-node reference to this node's next-node
        // reference
        linkedListImplTemp.setNext(linkedListImplCurrent.getNext());
        // now set this node's next-node reference to the new node
        linkedListImplCurrent.setNext(linkedListImplTemp);
        listCount++;// increment the number of elements variable
    }
 
    public Object get(int index)
    // returns the element at the specified position in this list.
    {
        // index must be 1 or higher
        if (index <= 0)
            return null;
 
        LinkedListNode linkedListImplCurrent = head.getNext();
        for (int i = 1; i < index; i++) {
            if (linkedListImplCurrent.getNext() == null)
                return null;
 
            linkedListImplCurrent = linkedListImplCurrent.getNext();
        }
        return linkedListImplCurrent.getData();
    }
 
    public boolean remove(int index)
    // removes the element at the specified position in this list.
    {
        // if the index is out of range, exit
        if (index < 1 || index > size())
            return false;
 
        LinkedListNode linkedListImplCurrent = head;
        for (int i = 1; i < index; i++) {
            if (linkedListImplCurrent.getNext() == null)
                return false;
 
            linkedListImplCurrent = linkedListImplCurrent.getNext();
        }
        linkedListImplCurrent.setNext(linkedListImplCurrent.getNext().getNext());
        listCount--; // decrement the number of elements variable
        return true;
    }
 
    public int size()
    // returns the number of elements in this list.
    {
        return listCount;
    }
 
    public String toString() {
    	LinkedListNode linkedListImplCurrent = head.getNext();
        String output = "";
        while (linkedListImplCurrent != null) {
            output += "[" + linkedListImplCurrent.getData().toString() + "]";
            linkedListImplCurrent = linkedListImplCurrent.getNext();
        }
        return output;
    }
 
}