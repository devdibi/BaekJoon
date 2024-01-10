import java.util.*;

class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        char[] text = cipher.toCharArray();
        
        for(int i = code-1; i < text.length; i += code){
            sb.append(text[i]);
        }
        
        return sb.toString();
    }
}