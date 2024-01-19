import java.util.*;

class Solution {
    int[] num;
    int[] select = new int[3];
    int answer = 0;
    public int solution(int[] nums) {
        num = nums;
        Arrays.fill(select, -1);
        comb(0,0);
        
        return answer;
    }
    
    public void comb(int cnt, int start){
        if(cnt == 3){
            int sum = 0;
            for(int i : select){
                sum += num[i];
            }
            
            // 소수 판별
            if(check(sum)){
                answer++;   
            }
            return;
        }
        
        for(int i = start; i < num.length; i++){
            select[cnt] = i;
            comb(cnt+1, i+1);
            select[cnt] = -1;
        }
    }
    public boolean check(int n){
        if(n % 2 == 0) return false;
        for(int i = 3; i < n; i+=2){
            if(n % i == 0) return false;
        }
        return true;
    }
}