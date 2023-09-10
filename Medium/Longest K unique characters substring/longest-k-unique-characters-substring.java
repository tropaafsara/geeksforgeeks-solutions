//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int i=0;
        int j=0;
        // StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        String str="";
        int freq=0;
        int max = -1;
        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch, 0)+1);
            if(map.size()<k){
            }

            if(map.size()==k){
                max = Math.max(max, j-i+1);
            }   
            else if(map.size()>k){
                while(map.size()>k){
                    Character ch2 = s.charAt(i);
                    map.put(ch2, map.get(ch2)-1);
                    if(map.get(ch2)==0){
                        map.remove(ch2);
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}