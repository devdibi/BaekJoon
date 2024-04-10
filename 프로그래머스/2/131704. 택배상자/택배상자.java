import java.util.*;

class Solution {
    public int solution(int[] order) {
        // 보조 컨테이너
        Stack<Integer> stack = new Stack<>();
        
        int idx = 0; // 실은 박스의 수
        
        for(int i = 1; i <= order.length; i++){
            if(order[idx] != i) {
                stack.push(i); // 순서 일치하지 않음
                continue;
            }
            
            idx++;
            
            // 순서 일치
            while(!stack.isEmpty() && stack.peek() == order[idx]){
                stack.pop();
                idx++;
            }
        }
        return idx;
    }
}