import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        // 2의 위치 파악
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2){
                list.add(i);
            }
        }
        if(list.size() == 0) return new int[]{-1};
        
        int start = list.get(0);
        int end = list.get(list.size()-1);
        
        int[] result = new int[end - start + 1];
        int idx = 0;
        for(int i = start; i <= end; i++){
            result[idx++] = arr[i];
        }
        return result;
    }
}