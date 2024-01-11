import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        for(int[] interval : intervals){
            for(int i = interval[0] ; i <= interval[1]; i++){
                list.add(arr[i]);
            }
        }
        
        // 배열 변환
        int[] result = new int[list.size()];
        
        int idx = 0;
        for(int i : list){
            result[idx++] = i;
        }
        return result;
    }
}