//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String s){
int i=0, j=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = -1;
        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch, 0)+1);
            if(map.size()==j-i+1){
                max = Math.max(max, j-i+1);
                j++;
            }   
            else if(map.size()<j-i+1){
                while(map.size()<j-i+1){
                    Character ch2 = s.charAt(i);
                    map.put(ch2, map.get(ch2)-1);
                    if(map.get(ch2)==0){
                        map.remove(ch2);
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
        
    }
}