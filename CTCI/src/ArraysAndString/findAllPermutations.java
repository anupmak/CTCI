package ArraysAndString;

import java.util.ArrayList;

public class findAllPermutations {

	/**
	 * @param args
	 */
	
	private char[] str;
	private ArrayList<String> list;

	public char[] getStr() {
		return str;
	}

	public void setStr(char[] str) {
		this.str = str;
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	public findAllPermutations(String str) {
		this.str = str.toCharArray();
		this.list = new ArrayList<String>();
		findPermute(this.str,0,str.length());
	}
	
	private void findPermute(char[] str,int s, int e){
		if(s==e){
			this.list.add(String.valueOf(str));
		}
		else{
			for(int i=s; i<e; i++){
				str = swap(str,i,s);				//swap i and s;
				findPermute(str,s+1,e);				//permute n-1 char	//backtracking
				str = swap(str,i,s);				//swap i and s;
			}
		}
	}
	
	private static char[] swap(char[] str, int index1, int index2){
		char ch = str[index1];
		str[index1] = str[index2];
		str[index2] = ch;
		return str;
	}

}
