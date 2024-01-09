import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        int i = 1;
        while(i <= n){
            if(i % 2 != 0){
                list.add(i);
            }
            i++;
        }
        int[] answer = new int[list.size()];
        
        int idx = 0;
        for(int j : list) answer[idx++] = j;
        
        return answer;
    }
}