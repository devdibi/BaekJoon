import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        // progresses는 작업의 개발 속도가 적히고 순서대로 배포되어야 한다.
        int[] dates = new int[len];
        
        for(int i = 0; i < len; i++){
            int temp = (100 - progresses[i]);
            dates[i] = temp / speeds[i] + (temp % speeds[i] != 0 ? 1 : 0);
        }
        
        int idx = 0;
        
        List<Integer> list = new ArrayList<>();
        
        while(idx < len){
            int cnt = 0;
            int first = dates[idx];
            
            while(idx < len && dates[idx] <= first){
                cnt++;
                idx++;
            }
            
            list.add(cnt);
        }
        
        int[] result = new int[list.size()];
        
        idx = 0;
        
        for(int i : list){
            result[idx++] = i;    
        }
        
        return result;
    }
}