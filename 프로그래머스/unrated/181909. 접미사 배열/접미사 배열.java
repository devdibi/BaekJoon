import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++){
            sb.append(my_string.substring(i)).append(" ");
        }
        
        String[] str = sb.toString().split(" ");
        Arrays.sort(str);
        return str;
    }
}