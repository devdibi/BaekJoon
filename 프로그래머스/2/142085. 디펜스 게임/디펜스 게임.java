import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        if(k >= enemy.length) {
            return enemy.length;
        }        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        
        int round = 0;
        
        for(int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            
            pq.offer(enemy[i]);
            
            if(n < 0) {
                if(k > 0) {
                    n += pq.poll();
                    k--;
                } else {
                    break;
                }
            }
            round++;
        }
        
        return round;
    }
}