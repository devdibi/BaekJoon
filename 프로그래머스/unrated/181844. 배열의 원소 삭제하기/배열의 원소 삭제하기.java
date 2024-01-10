import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        
        for(int i : arr){
            list.add(i);
        }
        
        for(int i : delete_list){
            list.remove(Integer.valueOf(i));
        }
        
        int[] result = new int[list.size()];
        int idx = 0;
        for(Integer i : list){
            result[idx++] = i;
        }
        return result;
    }
    
}