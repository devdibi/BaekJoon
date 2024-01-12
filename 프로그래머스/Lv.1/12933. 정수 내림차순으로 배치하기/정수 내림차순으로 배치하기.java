import java.util.*;

class Solution {
    public long solution(long n) {
        char[] str = String.valueOf(n).toCharArray();
        
        Arrays.sort(str);
        
        StringBuilder sb = new StringBuilder();
            
        for(int i = str.length - 1; i >= 0; i--){
            sb.append(str[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}