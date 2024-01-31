/*
    조건
        progresses의 index 순으로 배포를 한다.(뒤에서 완료가 되어도 앞에서 완료가 되지 않으면 배포 불가능)
    
    풀이 과정
        남은 진도를 기준으로 개발이 완료되는 시간을 구한다.
        순서대로 배포 가능 여부를 확인하고 뒤 순서의 개발이 앞 개발의 완료 기간보다 작을 경우 함께 배포가 가능하다.
*/

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int len = progresses.length;
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