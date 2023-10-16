//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int lcs(String s1, String s2, int n, int m){
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = 0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    int ans1 = dp[i][j-1];
                    int ans2 = dp[i-1][j];
                    dp[i][j]=  Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static String reverse(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
    static int minimumNumberOfDeletions(String s) {
        //your code here
        String t = reverse(s);
        return s.length() - lcs(s,t,s.length(),t.length());
    }
}