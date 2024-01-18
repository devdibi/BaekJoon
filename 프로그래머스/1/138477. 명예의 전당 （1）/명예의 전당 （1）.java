import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int len = score.length;
        
        int[] result = new int[len];
        int[] temp = new int[len];
        
        for(int i = 0; i < len; i++){
            temp[0] = score[i];
            Arrays.sort(temp);

            if(i < k){
                result[i] = temp[len -1 - i];
                continue;
            }
            
            result[i] = temp[len -k];
        }
        return result;
    }
}