import java.util.*;

class Solution{
    public int solution(int n, int a, int b){
        List<Integer> list = new ArrayList<>();
        
        int cnt = 0;
        // n에서 층의 개수를 파악한다.
        while(n != 1){
            n /= 2;
            cnt++;
        }
        
        for(int i = 0; i < cnt; i++){
            if(a % 2 != 0){
                a++;
            }
            if(b % 2 != 0){
                b++;
            }
            a /= 2;
            b /= 2;
            if(a == b) return i+1;
        }
        
        return 0;
        
    }
}