import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n > 0){
            // 짝수면 무조건 2배가 가능하므로 순간이동
            if(n % 2 == 0){
                n /= 2;
            }
            // 홀수면 순간이동이 불가능하므로 점프
            else{
                n--;
                ans++;
            }
        }
        
        return ans;
    }
}