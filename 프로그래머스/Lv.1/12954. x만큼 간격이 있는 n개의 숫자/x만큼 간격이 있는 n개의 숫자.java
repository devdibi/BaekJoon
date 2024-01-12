import java.util.*;
import java.util.stream.*;

class Solution {
    public long[] solution(int x, int n) {
        long[] list = new long[n];
        list[0] = x;
        for(int i = 1; i < n; i++){
            list[i] = list[i-1] + x;    
        }
        return list;
    }
}