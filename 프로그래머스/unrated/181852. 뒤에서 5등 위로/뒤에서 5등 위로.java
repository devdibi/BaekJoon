import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        int[] result = new int[num_list.length-5];
        for(int i = 5; i < num_list.length; i++){
            result[i-5] = num_list[i];
        }
        return result;
    }
}