import java.util.*;

class Solution {
    // 0000 ~ 9999
    int[] cars = new int[10000];
    boolean[] visited = new boolean[10000];
    
    public int[] solution(int[] fees, String[] records) {
        for(String s : records){
            String[] split = s.split(" ");
            
            // 시간 => 정수
            int time = 60 * Integer.parseInt(split[0].substring(0,2)) + Integer.parseInt(split[0].substring(3,5));
            
            // 차량 번호
            int idx = Integer.parseInt(split[1]);
            
            // 입차
            if(split[2].equals("IN")){
                cars[idx] -= time + 1;
                visited[idx] = true;
                continue;
            }
            
            // 출차
            cars[idx] += time + 1;
            visited[idx] = false;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        // 미 출차 차량 계산
        for(int i = 0; i < 10000; i++){
            if(cars[i] != 0) queue.offer(i);
                
            if(visited[i]){
                cars[i] += 1440;
                visited[i] = true;
            }
        }
        
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        // 요금 계산
        int[] result = new int[queue.size()];
        
        int idx = 0;
        while(!queue.isEmpty()){
            int time = cars[queue.poll()] - baseTime;
            
            result[idx] = baseFee; // 기본 요금
            
            if(time <= 0) {
                idx++;
                continue; // 기본 시간 보다 짧은 주차
            }
            
            result[idx] += (time / unitTime) * unitFee; // 단위 요금
            
            if(time % unitTime != 0){
                result[idx] += unitFee;
            }
            
            idx++;
        }
        
        return result;
    }
}
