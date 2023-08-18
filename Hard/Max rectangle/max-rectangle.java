//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    //nearest smaller element to left
    public static int[] nearestSmallerElementLeft(int[] arr, int n){//0(n)
        Stack<Integer> s = new Stack<>();
        int[] v = new int[n];
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                v[i]=-1;
            }else if(!s.isEmpty() && arr[s.peek()]<arr[i]){
                v[i] = s.peek();
            }else if(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    v[i]=-1;
                }else{
                    v[i] = s.peek();
                }
            }
            s.push(i);
        }
        return v;
    }
    //nearest smaller Element right
    public static int[] nearestSmallerElementRight(int[] arr, int n){//0(n)
        Stack<Integer> s = new Stack<>();
        int[] v = new int[n];
        for(int i=n-1;i>=0;i--){
            if(s.isEmpty()){
                v[i]=i+1;
            }else if(!s.isEmpty() && arr[s.peek()]<arr[i]){
                v[i] = s.peek();
            }else if(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    v[i]=n;
                }else{
                    v[i] = s.peek();
                }
            }
            s.push(i);
        }
        return v;
    }
    
    public static int maxAreaOfHistogram(int[] stocks, int n){//0(n)
        int[] nsr = nearestSmallerElementRight(stocks, n);
        int[] nsl =  nearestSmallerElementLeft(stocks, n);
        
        
        // System.out.print("nsl = ");
        // for (int i = 0; i < nsl.length; i++) {
        //     System.out.print(nsl[i] + " ");
        // }
        // System.out.println();
        // System.out.print("nsr = ");
        // for (int i = 0; i < nsr.length; i++) {
        //     System.out.print(nsr[i] + " ");
        // }
        // System.out.println();

        
        int[] width = new int[n];
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            width[i] = (nsr[i] - nsl[i] -1)*stocks[i];
            maxArea = Math.max(width[i], maxArea);
        }
        return maxArea;
    }
    public int maxArea(int M[][], int n, int m) {
        int[] v = new int[m];
        for(int i=0;i<m;i++){
           v[i] = M[0][i];
        }
        int max = maxAreaOfHistogram(v, m);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(M[i][j]==0){
                    v[j]=0;
                }else{
                    v[j] = v[j]+M[i][j];
                }
            }
            max = Math.max(max, maxAreaOfHistogram(v, m));
        }
        return max;
    }
}