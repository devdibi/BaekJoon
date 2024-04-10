import java.util.*;

class Solution {
    
    public int solution(int[] topping) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        // left에 토핑 하나 추가
        left.put(topping[0], 1);
        
        // right에 나머지 토핑 추가
        for(int i = 1; i < topping.length; i++){
            if(right.get(topping[i]) == null) {
                right.put(topping[i], 1); // 없으면 추가
                continue;
            }
            
            right.put(topping[i], right.get(topping[i]) + 1);
        }
        
        int cnt = 0;
        
        for(int i = 1; i < topping.length; i++){
            int temp = topping[i];
            if(left.get(temp) == null){
                left.put(temp, 1); // 없으면 추가
            }
            
            right.put(temp, right.get(temp) -1); // 빼기
            
            if(right.get(temp) == 0){
                right.remove(temp);
            }
            if(left.size() == right.size()) cnt++;
        }
        
        return cnt;
    }
    
    
}