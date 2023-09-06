//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    public static int find(int[] arr,int val,boolean flag){
        int start =0;
        int end =arr.length-1;
        int ans =-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(val==arr[mid]){
                ans = mid;
                if(flag){
                    end = mid-1;
                }else{
                    start = mid+1;
                } 
            }
            else if(val>arr[mid]){
                start = mid+1;
            }else if(val<arr[mid]){
                end = mid-1;
            }
        }
        return ans;
    }
    int count(int[] nums, int n, int x) {
        // code here
        int first = find(nums, x,true);
        int last = find(nums, x,false);
        if(first==-1 && last ==-1){
            return 0;
        }else{
            return last-first+1;
        }
        
    }
}