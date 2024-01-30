import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        Queue<Integer> queue = new ArrayDeque<>();
        int cnt = 0;
        
        for(int i : section){
            queue.offer(i);
        }
        
        while(queue.size() > 0){
            int start = queue.poll();
            
            // 마지막 하나만 남은 경우 => 종료
            if(queue.size() == 0){
                cnt++;
                break;
            }
            
            // 구역을 벗어나는 경우 => 종료
            if(start > n - m){
                cnt++;
                break;
            }
            // m의 범위 내에 포함되는 경우
            while(queue.peek() < start + m){
                queue.poll();
                if(queue.size() == 0) break;
            }
            cnt++;
        }
        return cnt;
    }
}