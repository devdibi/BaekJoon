import java.util.*;

class Solution {
    boolean solution(String s) {
        int status = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(status < 0) return false;
            
            if(s.charAt(i) == '(') status++;
            if(s.charAt(i) == ')') status--;
        }
        if(status != 0) return false;

        return true;
    }
}