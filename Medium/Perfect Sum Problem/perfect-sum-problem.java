//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp = new int[n+1][sum+1];

        for(int i=0;i<dp.length;i++){//row
            dp[i][0] = 1;
        }
        for(int i=1;i<dp[0].length;i++){//col
            dp[0][i] = 0;
        }
        //10^9 + 7
        int m = (int) 1e9+7;
        for(int i=1;i<n+1;i++){//row = n = i
            for(int j=0;j<sum+1;j++){//col = W = j
                if(arr[i-1]>j){
                 dp[i][j] = (dp[i-1][j])%m;   
                } 
                else if(arr[i-1]<=j){
                    int include = (dp[i-1][j-arr[i-1]])%m;
                    int exclude = (dp[i-1][j])%m;
                    dp[i][j] =(include+exclude)%m;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
	} 
}