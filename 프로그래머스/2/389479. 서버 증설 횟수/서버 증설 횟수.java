import java.util.*;

class Solution {
    public int solution(int[] players, int max, int time) {
        int addCount = 0;
        int curServer = 1;
        int curPeople = 0;
        int need = 0;
        
        for(int i = 0; i < 24; i++) {
            if(i >= time) {
                curServer -= players[i-time];
                if(curServer < 1) curServer = 1;
            } 
            
            need = getNeedServer(players[i], curServer, max);
            
            addCount += need;
            curServer += need;
            players[i] = need;
        }
        
        return addCount;
    }
    
     public Integer getNeedServer(int curPeople, int curServer, int max) {          
         int remain = curPeople - curServer * max;
         if(remain < 0) return 0;
         
         int need = remain / max;
         if(remain % max >= 0) need++;
         return need;   
     }
}