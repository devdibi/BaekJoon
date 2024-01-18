import java.util.*;

class Solution {
    int len;
    int[] select = new int[3];
    int[] people;
    int result = 0;
    public int solution(int[] number) {
        people = number;
        len = number.length;
        Arrays.fill(select, -1);
        
        comb(0,0);
        return result;
    }
    
    public void comb(int cnt, int start){
        if(cnt == 3){
            int sum = 0;
            for(int i : select){
                sum += people[i];
            }
            if(sum == 0) result++;
            return;
        }
        
        for(int i = start; i < len; i++){
            select[cnt] = i;
            comb(cnt+1, i+1);
            select[cnt] = -1;
        }
    }
}