import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        Arrays.sort(indices);
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i  < my_string.length(); i++){
            if(indices[idx] == i){
                if(idx < indices.length - 1) idx++;    
                continue;
            }
            sb.append(my_string.charAt(i));
        }
        return sb.toString();
    }
}