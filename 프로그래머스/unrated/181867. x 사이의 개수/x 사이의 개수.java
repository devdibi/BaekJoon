import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(String myString) {
        List<Integer> list = new ArrayList<>();
        
        int cnt = 0;
        
        for(char c : myString.toCharArray()){
            if(c == 'x'){
                list.add(cnt);
                cnt = 0;
            }else{
                cnt++;
            }
        }
        
        list.add(cnt);
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
        
    }
}