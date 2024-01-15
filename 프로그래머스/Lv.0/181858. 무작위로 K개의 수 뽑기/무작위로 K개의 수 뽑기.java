import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] result = new int[k];
        
        Arrays.fill(result, -1);
        
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        
        for(int i : arr){
            set.add(i);    
        }
        
        Integer[] setArr = set.toArray(new Integer[0]);
        
        int len = Math.min(k, set.size());
        for(int i = 0; i < len; i++){
            result[i] = setArr[i];
        }
        
        return result;
    }
}