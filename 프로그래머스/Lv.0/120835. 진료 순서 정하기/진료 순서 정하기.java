import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int n = emergency.length;
        int[] result = new int[n];
        
        for(int i = 0; i < n ; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(emergency[j] >= emergency[i]){
                    result[i]++;
                }
            }
        }
        return result;
    }
}