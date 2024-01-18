import java.util.*;
import java.util.stream.*;

class Solution {
    int[] select = new int[2];
    int[] nums;
    List<Integer> list = new ArrayList<>();
    public int[] solution(int[] numbers) {
        nums = numbers;
        Arrays.fill(select, -1);
        
        comb(0,0);
        
        int[] result = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);    
        }
        
        Arrays.sort(result);
        
        return result;
    }
    public void comb(int cnt, int start){
        if(cnt == 2){
            
            int sum = 0;
            for(int i = 0; i < select.length; i++){
                sum += nums[select[i]];
            }
            if(list.contains(sum)){
                return;
            }
            list.add(sum);
            return;
        }
        
        for(int i = start; i < nums.length; i++){
            select[cnt] = i;
            comb(cnt+1, i+1);
            select[cnt] = -1;
        }
    }
}