import java.util.*;

class Solution {
    public int[] solution(long n) {
        char[] list = String.valueOf(n).toCharArray();
        int[] result = new int[list.length];
        
        int idx = list.length - 1;
        
        for(char c : list){
            result[idx--] = (int)c - 48;
        }
        
        
        return result;
    }
}