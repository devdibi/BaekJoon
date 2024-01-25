import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(int[] elements) {
        int idx = 1;
        int len = elements.length;
        // 모든 길이의 수 만큼 합을 구한다.
        while(idx <= len){
            // 모든 원소에서 시작
            for(int i = 0; i < len; i++){
                int num = 0;
                for(int j = 0; j < idx; j++){
                    num += elements[(i + j) % len];
                }
                set.add(num);
            }
            idx++;
        }
        return set.size();
    }
}