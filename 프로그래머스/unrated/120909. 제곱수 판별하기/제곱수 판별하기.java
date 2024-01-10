import java.util.*;

class Solution {
    public int solution(int n) {
        double num = Math.sqrt(n);
        
        if((int) num < num){
            return 2;
        }
        return 1;
    }
}