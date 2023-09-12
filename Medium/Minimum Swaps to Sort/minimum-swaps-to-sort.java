//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    class pair{
        int a=0,b=0;
        pair(int a,int b)
        {
            this.a = a;
            this.b = b;
        }
    }
    public void swap(pair p1, pair p2, ArrayList<pair> al) {
        pair temp = al.get(p1.b);
        al.set(p1.b, al.get(p2.b));
        al.set(p2.b, temp);
    }
    public int minSwaps(int arr[])
    {
        // Code here
        int n = arr.length;
        ArrayList<pair> al = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            al.add(new pair(arr[i],i));// a = arr[i] , b = i
        }
        Collections.sort(al,(first,second)->(first.a - second.a));
        int count =0;
        for(int i=0;i<n;i++)
        {
            pair p = al.get(i);
            if(p.b!=i)
            {
                swap(p,al.get(p.b),al);
                count++;
                i--;
            }
                
        }
        return count;
    }
}