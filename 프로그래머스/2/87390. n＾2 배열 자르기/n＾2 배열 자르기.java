import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        long row = (long)n;
        List<Integer> list = new ArrayList<>();
        long idx = left;
        while(idx <= right){
            list.add(idx / row > idx % row ? (int)(idx / row) + 1 : (int)(idx % row) + 1);
            idx++;
        }
        
        int[] result = new int[list.size()];
        int index = 0;
        for(int i : list){
            result[index++] = i;
        }
        
        return result;
    }
}

