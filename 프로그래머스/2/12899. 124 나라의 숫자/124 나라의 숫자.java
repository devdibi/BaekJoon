import java.util.*;

class Solution {
    public String solution(int n) {
        char[] nums = {'4','1','2'};
        
        Stack<Character> stack = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            stack.push(nums[n % 3]);
            n = (n - 1) / 3;
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.toString();
        
    }
}
