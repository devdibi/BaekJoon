import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int[] line = new int[201];
        
        for(int[] l : lines){
            for(int i = l[0] ; i < l[1]; i++){
                line[i+100]++;
            }
        }
        int cnt = 0;
        for(int i : line){
            if(i != 0 && i != 1){
                cnt++;
            }
        }
        
        return cnt;
    }
}