package ArraysAndString;

public class StringRotation {

	/*Assume you have a method i 5Su b 5 tr ing which checks if one word is a substring
	of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
	call to i5Sub5tring (e.g., "waterbottle" is a rotation of" erbottlewat").
	*/

	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.println(solution1(s1,s2));
	}

	private static boolean solution1(String s1, String s2) {
		if(s1.length()==s2.length()) return isSubString(s1+s1,s2);
		return false;							// if length are different - it will be rotated sub-string 
	}											//but not complete string
	

	private static boolean isSubString(String s1, String s2) {
		for(int i=0; i<s2.length(); i++)
			if(s1.indexOf(s2.charAt(i))==-1) return false;
		return true;
	}

}
