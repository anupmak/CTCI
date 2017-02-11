package ArraysAndString;

public class OneAway {

	/*There are three types of edits that can be performed on strings: insert a character,
	remove a character, or replace a character. Given two strings, write a function to check if they are
	one edit (or zero edits) away.
	EXAMPLE
	pale, ple -> true
	pales, pale -> true
	pale, bale -> true
	pale, bake -> false
	*/

	public static void main(String[] args) {
		String s1 = "pale";
		String s2 = "bake";
		solution1(s1,s2);
	}

	private static void solution1(String s1, String s2) {
		int[] set = new int[26];
		int i=0;
		int oneAway = 0;
		
		for(i=0; i<s1.length(); i++)
			set[s1.charAt(i) -'a']++;

		for(i=0; i<s2.length(); i++)
			set[s2.charAt(i)-'a']--;
		
		for(i=0; i<26; i++){
			if(0<set[i]){
				if(1<oneAway) break;
				oneAway++;
			}
		}
		System.out.println(oneAway<2);
	}
}
