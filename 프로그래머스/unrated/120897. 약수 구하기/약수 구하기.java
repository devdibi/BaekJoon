import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        int idx = 1;
        
        while(idx <= n){
            if(n % idx == 0){
                list.add(idx);
            }
            idx++;
        }
        int[] result = new int[list.size()];
        idx = 0;
        for(int i : list){
            result[idx++] = i;    
        }
        return result;
    }
}