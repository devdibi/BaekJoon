import java.util.*;
import java.util.stream.*;


class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int n = col - 1;
        
        Arrays.sort(data, (a, b) -> {
            if(a[n] == b[n]) return b[0] - a[0];
            return a[n] - b[n];
        });
        
        int answer = 0;

        for(int i = row_begin - 1; i < row_end; i++) {
            int s = 0;
            for(int d : data[i]) {
                s += d % (i+1);
            }
            answer ^= s;
        }
        return answer;
    }
}