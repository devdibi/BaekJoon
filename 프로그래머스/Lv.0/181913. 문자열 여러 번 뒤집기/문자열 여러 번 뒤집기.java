import java.util.*;

class Solution {
    int[] idx;
    public String solution(String my_string, int[][] queries) {
        idx = new int[my_string.length()];
        
        for(int i = 0; i < idx.length;i++){
            idx[i] = i;
        }
        
        for(int [] query : queries){
            reverse(query[0], query[1]);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i : idx){
            sb.append(my_string.charAt(i));
        }
        
        return sb.toString();
    }
    public void reverse(int s, int e){
        Stack<Integer> stack = new Stack<>();
        
        for(int i = s; i <= e; i++){
            stack.push(idx[i]);
        }
        
        for(int i = s; i <= e; i++){
            idx[i] = stack.pop();
        }
        
    }
}