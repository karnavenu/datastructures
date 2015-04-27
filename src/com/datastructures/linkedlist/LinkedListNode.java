package com.datastructures.linkedlist;

public class LinkedListNode {


    // reference to the next node in the chain,
    // or null if there isn't one.
	LinkedListNode next;
    // data carried by this node.
    // could be of any type you need.
    Object data;

    // Node constructor
    public LinkedListNode(Object dataValue) {
        next = null;
        data = dataValue;
    }

    // another Node constructor if we want to
    // specify the node to point to.
    public LinkedListNode(Object dataValue, LinkedListNode nextValue) {
        next = nextValue;
        data = dataValue;
    }

    // these methods should be self-explanatory
    public Object getData() {
        return data;
    }

    public void setData(Object dataValue) {
        data = dataValue;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode nextValue) {
        next = nextValue;
    }

}
