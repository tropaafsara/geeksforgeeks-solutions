//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            String inputLine[] = br.readLine().trim().split(" "); 
            int n = Integer.parseInt(inputLine[0]); 
            int x = Integer.parseInt(inputLine[1]);
            
            int arr[] = new int[(int)(n)];
            
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine1[i]);
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.firstAndLast(arr, n, x); 
            
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    } 
} 
            



// } Driver Code Ends


//User function Template for Java
class Solution{
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
    public ArrayList<Integer> firstAndLast(int arr[], int n, int x){
        ArrayList<Integer> list = new ArrayList<>();
        int first = find(arr, x,true);
        int last = find(arr, x,false);
        if(first==-1 && last ==-1){
            list.add(-1);
            return list;
        }else{
            list.add(first);
            list.add(last);
        }
        return list;
    }
}
