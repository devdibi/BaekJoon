import java.util.*;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        
        int idx = 0;
        int sum = 0;
        int time = 0;
        
        while(true){
            if(bridge.size() == bridge_length){
                sum -= bridge.poll();
            }
            
            time++;
            if(idx < truck_weights.length){
                if(sum + truck_weights[idx] <= weight){
                    sum += truck_weights[idx];
                    bridge.offer(truck_weights[idx++]);
                }else{
                    bridge.offer(0);
                }    
            }else{
                time += bridge_length -1;
                return time;
            }
        }
    }
}