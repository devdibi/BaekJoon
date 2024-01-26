import java.util.*;

class Solution {
    char[] str;
    
    Map<Character,Character> map = new HashMap<>();
    
    public int solution(String s) {
        str = s.toCharArray();
        
        map.put('[',']');
        map.put('{','}');
        map.put('(',')');
        
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            // System.out.println(Arrays.toString(str));
            if(check()) result++;
            
            cycle();
        }
        
        return result;
    }
    // 회전
    public void cycle(){
        char c = str[0];
        
        for(int i = 0; i < str.length - 1; i++){
            str[i] = str[i+1];
        }
        
        str[str.length - 1] = c;
    }
    
    // 탐색
    public boolean check(){
        Stack<Character> stack = new Stack<>();
        
        // 전체 확인
        for(int i = 0; i < str.length; i++){
            // 시작이 닫힌 괄호이면 무조건 패스
            if(str[i] == '[' || str[i] == '{' || str[i] == '(') {
                stack.push(str[i]);
                continue;
            }
            
            if(stack.isEmpty()){
                return false;
            }
            
            
            if(map.get(stack.peek()) == str[i]){
                stack.pop();
            }else{
                return false;
            }
        }
        
        if(!stack.isEmpty()) return false;
        return true;
    }
    
}