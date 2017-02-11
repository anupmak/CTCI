package LinkedList;

import java.util.Scanner;

public class DeleteNthRow {

	private static void formAList(String[] sArray,LinkedListNode tempHead) {
		LinkedListNode temp = tempHead;
		int i = 0, j = sArray.length, n;
		temp.setData(Integer.parseInt(sArray[0]));
		
		for(i=1 ; i < (j-1) ; i++) {
			n = Integer.parseInt(sArray[i]);
			LinkedListNode tempNode = new LinkedListNode(n,null);
			temp.setNext(tempNode);
			temp = temp.getNext();
		}
	}
	
	private static String toString(LinkedListNode tempHead) {
		LinkedListNode temp = tempHead.getNext();
		String res = String.valueOf(tempHead.getData());
		while(temp != null){
			res = res + " -> " + String.valueOf(temp.getData());
			temp = temp.getNext();
		}
		return res;
	}

	private static LinkedListNode moveToNthElement(LinkedListNode tempHead, int index) {
		for(int i =0; i < (index -1); i++){
			tempHead = tempHead.getNext();
		}
		return tempHead;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(); 
		Scanner in 			= new Scanner(System.in);
		String s 			= in.nextLine();
		String[] sArray 	= s.split("\\s+");
		int j = sArray.length, index;
		index = Integer.parseInt(sArray[j-2]);
		
		// creating list of nodes
		formAList(sArray,head);
		// printing nodes
		System.out.println("formAList : " + toString(head));
		
		LinkedListNode tempHead = head;
		LinkedListNode temp 	= moveToNthElement(tempHead,index);
		// printing nodes
		System.out.println("formAList : " + toString(temp));		

		temp.setNext(temp.getNext().getNext());
		// printing nodes
		System.out.println("formAList : " + toString(head));		
		
		in.close();
	}
}

//2 3 56 1 88 2 end

