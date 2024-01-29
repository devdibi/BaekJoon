import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int result = -1;
        // 1. 정렬
        Arrays.sort(citations);
        int len = citations.length;
        
        // 2. h번 이상 인용된 논문의 수가 a편 이면 이중 작은 값이 해당 논문의 H-index이다.
        for(int i = 0; i < citations.length; i++){
            int h = citations[i];
            
            int up = len - i;
            
            result = Math.max(result, Math.min(h, up));
            
        }
        return result;   
    }
}