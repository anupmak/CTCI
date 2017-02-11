package LinkedList;

import java.util.Scanner;

public class AddNosLinkedList {
	
	private static void formAList(String[] sArray,LinkedListNode tempHead) {
		LinkedListNode temp = tempHead;
		int j = sArray.length, n;
		temp.data = Integer.parseInt(sArray[0]);
		
		for(int i=1 ; i < j ; i++) {
			n = Integer.parseInt(sArray[i]);
			LinkedListNode tempNode = new LinkedListNode(n,null);
			temp.next = tempNode;
			temp = temp.next;
		}
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
	
	private static LinkedListNode addNumbers(LinkedListNode no1,LinkedListNode no2) {
		int s=0,carry=0;
		LinkedListNode head = new LinkedListNode();
		LinkedListNode no3 = new LinkedListNode();
		head = no3;
		carry = (no1.data + no2.data + carry)/10;
		no3.data = (no1.data + no2.data + carry)%10;
		no1 = no1.next;
		no2 = no2.next;
		while ((no1!=null) && (no2!=null)){
			s = no1.data + no2.data + carry;
			carry = s/10;
			LinkedListNode temp = new LinkedListNode(s%10,null);
			no3.next = temp;
			no3 = no3.next;
			no1 = no1.next;
			no2 = no2.next;
		}
		if(carry!=0){
			LinkedListNode temp = new LinkedListNode(carry,null);
			no3.next = temp;
		}
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LinkedListNode no1 	= new LinkedListNode();
		LinkedListNode no2 	= new LinkedListNode(); 
		Scanner in 			= new Scanner(System.in);
		String[] sArray		= new String[100]; 
		String currentLine; 
		int i=0; 

		do { 
			currentLine = in.nextLine(); 
			sArray[i]= currentLine; 
			i++; 
		} while (!currentLine.equals("")); 
		
		// creating list of nodes
		String[] num1 	= (sArray[0].split("\\s+"));
		formAList(num1,no1);
		// printing nodes
		System.out.println("No1 : " + toString(no1));
		
		// creating list of nodes
		String[] num2 	= (sArray[1].split("\\s+"));
		formAList(num2,no2);
		// printing nodes
		System.out.println("No2 : " + toString(no2));
		
		LinkedListNode no3 = addNumbers(no1,no2);
		System.out.println("Sum : " + toString(no3));
		
		in.close();
	}
}

