package ArraysAndString;

public class StringCompression {

	/*
	Implement a method to perform basic string compression using the counts
	of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
	"compressed" string would not become smaller than the original string, your method should return
	the original string. You can assume the string has only uppercase and lowercase letters (a - z).
	*/
	
	public static void main(String[] args) {
		String str = "aabcccccaaa";
		System.out.println(str);
		solution1(str);
	}

	private static void solution1(String str) {
		int i=1, l=str.length(), cnt=1;
		StringBuilder result= new StringBuilder();
		while(i<l){
			if(str.charAt(i-1)==str.charAt(i))
				cnt++;
			else{
				result.append(str.charAt(i-1) + "" + cnt);
				cnt=1;
			}
			i++;
		}
		result.append(str.charAt(i-1) + "" + cnt);
		System.out.println(result);
	}
}
