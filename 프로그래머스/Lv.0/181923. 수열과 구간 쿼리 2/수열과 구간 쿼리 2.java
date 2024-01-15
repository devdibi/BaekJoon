import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int NUM = 1_000_000;
        Arrays.fill(result, NUM);
        
        int idx = 0;
        
        for(int[] query : queries){
            int s = query[0];
            int e = query[1];
            int k = query[2];
            
            for(int i = s; i <= e; i++){
                if(arr[i] <= k) continue;
                
                result[idx] = Math.min(result[idx], arr[i]);
             
            }
            
            if(result[idx] == NUM){
                result[idx] = -1;
            }
            
            idx++;
        }
        return result;
    }
}