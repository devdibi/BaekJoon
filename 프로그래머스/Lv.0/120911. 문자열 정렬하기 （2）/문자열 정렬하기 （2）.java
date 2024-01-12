import java.util.*;
class Solution {
    public String solution(String my_string) {
        char[] str = my_string.toLowerCase().toCharArray();
        
        Arrays.sort(str);
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : str){
            sb.append(c);
        }
        
        return sb.toString();
    }
}