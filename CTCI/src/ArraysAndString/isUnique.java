package ArraysAndString;

import java.util.HashMap;
import java.util.Scanner;

public class isUnique {
	
    public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
    	String str = in.nextLine();
        boolean isUnique = findIfUniqueWithSpace(str);
        System.out.println(isUnique);
        boolean isUnique2 = findIfUniqueWithConstantSpace(str);
        System.out.println(isUnique2);
        in.close();
    }
    
    private static boolean findIfUniqueWithConstantSpace(String str) {
    	boolean[] set = new boolean[128]; //assuming only ascii characters
    	int i =0;
    	char ch;
    	for(i=0; i<str.length();i++){
    		ch = str.charAt(i);
    		if(set[ch]) return false;
    		set[ch] = true;
    	}
    	return true;
	}

	private static boolean findIfUniqueWithSpace(String str){
        int i=0,l=str.length();
        Character ch;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        while(i<l){
            ch = str.charAt(i);
            if(map.get(ch)==null)
                map.put(ch,1);            
            else
                map.put(ch,map.get(ch)+1);
            i++;
        }
        //System.out.println(map.keySet());
        //System.out.println(map.values());
        for(Integer val : map.values()){
            if(1<val)
                return false;
        }
        return true;
    }
}
