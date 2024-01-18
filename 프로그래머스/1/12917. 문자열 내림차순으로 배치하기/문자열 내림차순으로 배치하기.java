import java.util.*;

class Solution {
    public String solution(String s) {
        String[] str = s.split("");
        
        Arrays.sort(str);
        StringBuilder sb = new StringBuilder();
        for(int i = str.length -1; i >= 0; i--){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}