package ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckPermutation {

	public static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "cea";
		boolean found = false;
		
		System.out.println(s1);
		System.out.println(s2);
		
		if(s1.length()!=s2.length()){ 
			found = false;
			System.out.println(found);
		}
		else{
			found = withAllPermute(s1,s2);
			System.out.println(found);
			
			found = withSorting(s1,s2);
			System.out.println(found);
			
			found = findIfUniqueWithConstantSpace(s1,s2);
			System.out.println(found);
		}
	}

    private static boolean findIfUniqueWithConstantSpace(String s1, String s2) {
    	int[] set = new int[128]; //assuming only ascii characters
    	int i =0;
    	char ch;
    	for(i=0; i<s1.length();i++){
    		ch = s1.charAt(i);
    		set[ch]++;
    	}
    	
    	for(i=0; i<s2.length();i++){
    		ch = s2.charAt(i);
    		set[ch]--;
    		if(set[ch]<0) return false;
    	}
    	return true;
	}
    
	private static boolean withSorting(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		int i=0;
		while(i<c1.length){
			if(c1[i]!=c2[i]) return false;
			i++;
		}
		return true;
	}

	private static boolean withAllPermute(String s1, String s2) {
		findAllPermutations fn = new findAllPermutations(s1);
		list = fn.getList();			//find all permutations of s1
		//System.out.println(list);
		
		for(String s : list){
			if(s.equals(s2)){			//compare with s2
				return true;
			}
		}		
		return false;
	}
}
