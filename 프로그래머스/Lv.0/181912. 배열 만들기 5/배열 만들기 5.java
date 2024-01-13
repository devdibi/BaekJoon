import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        
        for(String str : intStrs){
            int num = pop(str,s,l);
            if(num > k){
               list.add(num);
            }
        }
        int[] result = new int[list.size()];
        int idx = 0;
        for(Integer i : list){
            result[idx++] = i;
        }
        return result;
    }
    
    public int pop(String str, int s, int l){
        return Integer.parseInt(str.substring(s,s+l));
    }
}