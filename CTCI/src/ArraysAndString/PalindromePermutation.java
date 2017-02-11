package ArraysAndString;

public class PalindromePermutation {
	
	/*
	Given a string, write a function to check if it is a permutation of a palindrome. 
	A palindrome is a word or phrase that is the same forwards and backwards. 
	A permutation is a rearrangement of letters. 
	The palindrome does not need to be limited to just dictionary words. 
	EXAMPLE Input: Tact Coa Output: True (permutations: "taco cat", "atco eta", etc.) 
	*/
	
	public static void main(String[] args ){
		String str = "t a c e e c a t";
		System.out.println(str);
		solution1(str);
	}

	private static void solution1(String str) {
		int[] set = new int[26];			// store count of all characters
		int i=0, l=0, odd=0;
		char ch;
		boolean foundOdd = false;
		int cntOdd = 0;
		
		for(i=0; i<str.length();i++){
			ch = str.charAt(i);
			if(ch!=' '){
				set[ch-'a']++;				// add count+1 for given char
				l++;
			}
		}

		for(i=0; i<str.length();i++){
			ch = str.charAt(i);
			if(ch!=' '){
				int val = set[str.charAt(i)-'a'];

/* Approach 1	
				if(val%2==0){						// if count is even, remove from total length
					l-=1;
				}	
				else
					odd=val;						// if odd, at the end there should be only one odd term if palindrome.
													// and this should match with length remaining
*/
/* Approach 2				
				if(val%2==1){
					if(foundOdd) break;
					foundOdd = true;
				}
				
*/
				if(val%2==1) cntOdd++;
				else cntOdd--;
			}
		}
		
		//System.out.println(l==odd);
		//System.out.println(!foundOdd);
		System.out.println(cntOdd<=1);				// should be less than 1 or max 1
	}
}
