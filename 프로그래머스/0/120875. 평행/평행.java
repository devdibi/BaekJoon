import java.util.*;

class Solution {
    int[][] loc;
    public int solution(int[][] dots) {
        loc = dots;
        
        for(int i = 0; i < 3; i++){
            if(tilt(select[i]) == tilt(notSelect[i])) return 1;
        }
        
        return 0;
    }
    int[][] select = {{0,1},{0,2},{0,3}};
    int[][] notSelect = {{2,3},{1,3},{1,2}};
    
    public double tilt(int[] dot){
        return ((double)loc[dot[0]][0] - (double)loc[dot[1]][0]) / ((double)loc[dot[0]][1] - (double)loc[dot[1]][1]);
    }
}