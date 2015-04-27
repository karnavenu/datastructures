package com.datastructures.arraysandstrings;



import java.util.ArrayList;
import java.util.Scanner;

public class Anagrams {
    
    
    
    public static void main (String args[])
    {
//        System.out.println("Please enter the string whose permutations we need to show ");
//        Scanner in = new Scanner(System.in);
//        String original=in.nextLine();
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
//        System.out.println("Results are :");
//        System.out.println("");
//        System.out.println("");
//        permute(original);
        
        String input = "aac";
//        permutation(input, "");
        ArrayList<String> list = recursivePermute(input,new int[200]);
        System.out.println(list.toString());
    }
    
    
    
    public static   void permute( String input)
    {
        int inputLength = input.length();
        boolean[ ] used = new boolean[ inputLength ];
        StringBuffer outputString = new StringBuffer();
        char[ ] in = input.toCharArray( );
        doPermute ( in, outputString, used, inputLength, 0 );
        
    }
    
    public static    void doPermute ( char[ ] in, StringBuffer outputString,
    boolean[ ] used, int inputLength, int level)
    {
        if( level == inputLength) {
            System.out.println ( outputString.toString());
            return;
        }
        
        for( int i = 0; i < inputLength; ++i )
        {
            
            if( used[i] ) continue;
            
            outputString.append( in[i] );
            used[i] = true;
            doPermute( in,   outputString, used, inputLength, level + 1 );
            used[i] = false;
            outputString.setLength(   outputString.length() - 1 );
        }
    }
    
    private static void permutation(String input, String sofar) {
        // TODO Auto-generated method stub
        
        if (input.equals("")) {
            System.out.printf("%s,", sofar);
        }
        for (int i = 0; i <input.length(); i++) {
            char c = input.charAt(i);
            if (input.indexOf(c, i + 1) != -1)
            continue;
            permutation(input.substring(0, i) + input.substring(i + 1), sofar+c);
        }
    }
    
    
     
    private static ArrayList<String> recursivePermute(String str, int[] used){
    	if(str == null){
    		return null;
    	}    	

    	ArrayList<String> list = new ArrayList<String>();
    	
    	if(str.length()==0){
    		list.add("");
    		return list;
    	}
    	
    	
    	char firstChar = str.charAt(0);
    	String reminderStr = str.substring(1);
    	if(used[firstChar]!=1){
    		used[firstChar]=1;
    	}else{
    		return list;
    	}
    	ArrayList<String> words = recursivePermute(reminderStr,used);
    	
    	for(String word : words){
    		
    		for(int i=0;i<=word.length();i++){
    			String s = insertChar(firstChar,word,i);
    			list.add(s);
    		}
    	}
    	return list;
    	
    }



	private static String insertChar(char firstChar, String word, int i) {
		String prev = word.substring(0,i);
		String next = word.substring(i);
		
		return prev+firstChar+next;
		
	}
    
}

