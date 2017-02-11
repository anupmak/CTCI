package LinkedList;

import java.util.*;

import LinkedList.LinkedListNode;



public class SinglyLinkedList {

	private static void formAList(String[] sArray,LinkedListNode tempHead) {
		LinkedListNode temp = tempHead;
		int i = 0, j = sArray.length, n;
		temp.data = Integer.parseInt(sArray[0]);
		
		for(i=1 ; i < (j-1) ; i++) {
			n = Integer.parseInt(sArray[i]);
			LinkedListNode tempNode = new LinkedListNode(n,null);
			temp.next = tempNode;
			temp = temp.next;
		}
	}
	
	private static void addAtEnd(int n,LinkedListNode tempHead) {
		LinkedListNode temp 	= tempHead;
		LinkedListNode tempNode = new LinkedListNode(n,null);
		while(temp.next != null) 	// traverse list till the end
			temp = temp.next;
		temp.next = tempNode; 		// add new node at the end
	}

	private static String toString(LinkedListNode tempHead) {
		LinkedListNode temp = tempHead.next;
		String res = String.valueOf(tempHead.data);
		while(temp != null){
			res = res + " -> " + String.valueOf(temp.data);
			temp = temp.next;
		}
		return res;
	}
	
	private static LinkedListNode reverseNewList(LinkedListNode tempHead){
		LinkedListNode reversed = new LinkedListNode(tempHead.data,null);
		LinkedListNode temp = tempHead.next;
		while(temp != null){
			int n = temp.data;
			LinkedListNode rev = new LinkedListNode(n,null);
			rev.next = reversed;
			reversed = rev; 
			temp = temp.next;
		}
		return reversed;
	}
	
	private static LinkedListNode reverseSameList(LinkedListNode inHead){

		LinkedListNode tempHead = inHead;
		LinkedListNode itr = new LinkedListNode(tempHead.data, null);
		LinkedListNode outHead = new LinkedListNode(tempHead.data, null);
		tempHead = tempHead.next;

		while(tempHead != null){
			itr 		= tempHead;
			tempHead	= tempHead.next;
			itr.next 	= outHead;
			outHead 	= itr;
		}
		return outHead;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedListNode head = new LinkedListNode(); 
		Scanner in 			= new Scanner(System.in);
		String s 			= in.nextLine();
		String[] sArray 	= s.split("\\s+");
		int i = 0, j = sArray.length, n;
		
		//adding nodes
		head.data = Integer.parseInt(sArray[0]);
		for(i=1 ; i < (j-1) ; i++) {
			n = Integer.parseInt(sArray[i]);
			addAtEnd(n,head);
		}
		// printing nodes
		System.out.println("addAtEnd : " + toString(head));
		
		// creating list of nodes
		//formAList(sArray,head);
		// printing nodes
		//System.out.println("formAList : " + toString(head));
				
		//reverse of list
		//LinkedListNode reversedNewList = reverseNewList(head);
		// printing nodes
		//System.out.println("reverseNewList : " + toString(reversedNewList));

		// printing nodes
		//System.out.println("OriginalList : " + toString(head));
		
		//reverse of list with no extra space 
		head = reverseSameList(head);
		// printing nodes
		System.out.println("reverseSameList : " + toString(head));
		in.close();
	}
}

/*
 * 1 2 3 56 1 88 4 end
 */

