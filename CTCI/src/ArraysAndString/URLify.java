package ArraysAndString;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class URLify {

	public static void main(String[] args) {
		String urlStr = "Mr John Smith";
		int length = urlStr.length();
				
		System.out.println(urlStr + " " + length);
		solution1(urlStr);
		solution2(urlStr);
		solution3(urlStr,length);
	}
	
	private static void solution3(String url, int len) {
		int j=0,k=0;
		
		while(j<len){
			if(url.charAt(j)==' ')
				k++;
			j++;
		}
		
		k = k*2 + len;
		char[] ch = new char[k];
		j=len-1;
		k--;
		while(0<=j){
			if(url.charAt(j)==' '){
				ch[k]='0';
				ch[k-1]='2';
				ch[k-2]='%';
				j--;k-=3;
			}
			else{
				ch[k]=url.charAt(j);
				j--;k--;
			}
		}
		
		System.out.println(String.valueOf(ch));
	}

	private static void solution2(String urlStr){
		int l1 = urlStr.length();
		//int l2 = l1 - urlStr.replaceAll(" ","").length();
		
		String res = "";
		char[] charArray = urlStr.toCharArray();
		//System.out.println(charArray);
		char ch = charArray[l1-1];
		res = (ch==' ')?"":""+ch;
		int i = l1-2;
		while(0<=i){
			ch = charArray[i];
			
			if(ch==' ' && charArray[i+1]==' ')
				res = "" + res;
			else if(ch==' ')
				res = "%20" + res;
			else
				res = charArray[i] + res;
			i--;
		}
		System.out.println(res);
	}
	
	private static void solution1(String urlStr){
		String c = "%20", single=null;
		StringBuilder res = new StringBuilder();
		List<String> urlList = Arrays.asList(urlStr.split(" "));
		//System.out.println(urlList);

		Iterator<String> iter = urlList.iterator();
		res.append(iter.next());
		while(iter.hasNext()){
			single = iter.next();
			if(single.length()!=0)
				res.append(c+single);
		}
		
		System.out.println(res.toString());			
	}
}
