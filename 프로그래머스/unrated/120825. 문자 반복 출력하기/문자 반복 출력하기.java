import java.util.*;

class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        
        String[] sp = my_string.split("");
        
        int start = 0;
        
        for(int i = 0; i < my_string.length(); i++){
            start = 0;
            while(start < n){
                sb.append(sp[i]);    
                start++;
            }
            
        }
                 
        return sb.toString();
    }
}