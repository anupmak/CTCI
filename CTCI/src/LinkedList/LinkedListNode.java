package LinkedList;

public class LinkedListNode {
	
	int data;
	LinkedListNode next;
	
	public LinkedListNode() {
		super();
	}
	
	public LinkedListNode(int data, LinkedListNode next) {
		super();
		this.data = data;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public LinkedListNode getNext() {
		return next;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}
}


