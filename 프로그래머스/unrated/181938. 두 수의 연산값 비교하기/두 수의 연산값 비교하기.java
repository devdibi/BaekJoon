import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int a, int b) {
        
        return cal(a,b) > 2 * a * b ? cal(a,b) : 2 * a * b;
        
        
        
    }
    public int cal(int a, int b){
        StringBuilder sb= new StringBuilder();
        sb.append(String.valueOf(a)).append(String.valueOf(b));
        return Integer.parseInt(sb.toString());
    }
    
}