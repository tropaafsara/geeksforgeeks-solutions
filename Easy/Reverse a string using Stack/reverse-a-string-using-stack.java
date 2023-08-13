//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Solution obj = new Solution();
            System.out.println(obj.reverse(sc.next()));
        }
	}
}

// } Driver Code Ends


class Solution {
    
    public String reverse(String str){
        Stack<Character> s = new Stack<>();
        String str2 = "";
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            s.push(ch);
        }
        while(!s.isEmpty()){
            str2+=s.peek();
            s.pop();
        }
        return str2;
    }

}