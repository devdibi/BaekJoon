import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        int idx = my_string.length()-1;
        
        while(idx >= 0 ){
            sb.append(my_string.charAt(idx--));
        }
        
        return sb.toString();
    }
}