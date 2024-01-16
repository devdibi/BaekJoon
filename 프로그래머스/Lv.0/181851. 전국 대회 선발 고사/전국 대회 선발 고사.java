import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] num = new int[3];
        
        List<Integer> list = Arrays.stream(rank).boxed().collect(Collectors.toList());
        
        int idx = 0;
        
        for(int i = 1; i <= rank.length;i++){
            if(idx == 3) break;
            if(attendance[list.indexOf(i)]){
                num[idx++] = list.indexOf(i); 
            }
        }
        
        int result = 0;
        int[] arr = {10000,100,1};
        for(int i = 0; i < 3; i++){
            result += num[i] * arr[i];
        }
        return result;
    }
}