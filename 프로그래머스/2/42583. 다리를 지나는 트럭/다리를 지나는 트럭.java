import java.util.*;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        
        int idx = 0; // 트럭의 순서
        int sum = 0; // 최대 하중
        int time = -1; // 걸린 시간
        
        while(true){
            time++; // 시간 추가
            
            // 트럭 탈출
            if(bridge.size() == bridge_length){
                sum -= bridge.poll();
            }
            
            // 마지막 트럭의 진입 여부 확인
            if(idx < truck_weights.length){
                if(sum + truck_weights[idx] <= weight){
                    // 최대 하중 초과 여부 확인
                    sum += truck_weights[idx];
                    bridge.offer(truck_weights[idx++]);
                }else{
                    // 최대 하중 초과 시 무게가 0인 트럭으로 대체
                    bridge.offer(0);
                }    
            }else{
                // 마지막 트럭이 진입한 경우 이 트럭이 나오는 시간을 더 해주면 종료
                time += bridge_length;
                return time;
            }
        }
    }
}