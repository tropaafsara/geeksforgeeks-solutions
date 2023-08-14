//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int checkRedundancy(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==')'){
                char top = s.peek();
                s.pop();
                int flag =1;
                while(!s.isEmpty() && top!='('){
                    if(top=='+'||top=='-'||top=='*'||top=='/'){
                        flag =0;
                    }
                    top = s.peek();
                    s.pop();
                } 

                if(flag==1){
                    return 1;
                }

            }else{
                s.push(ch);
            }
        }
        return 0;
        
    }
}
        
