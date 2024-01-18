import java.util.*;

public class Solution {
    Queue <Integer> queue = new ArrayDeque<>();
    public int[] solution(int []arr) {
        int now = arr[0];
        queue.offer(arr[0]);
        
        for(int i = 1; i < arr.length; i++){
            if(now == arr[i]) continue;
            now = arr[i];
            queue.offer(now);
        }
        int[] result = new int[queue.size()];
        
        for(int i = 0; i < result.length; i++){
            result[i] = queue.poll();
        }
        return result;
    }
    
}