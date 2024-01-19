import java.util.*;
class Solution{
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        
        char[] str = s.toCharArray();
        
        for(int i = 0; i < str.length; i++){
            if(!stack.isEmpty() && stack.peek() == str[i]){
                stack.pop();
            }else{
                stack.push(str[i]);
            }
        }
        
        if(stack.size() != 0){
            return 0;
        }
        return 1;
    }
}