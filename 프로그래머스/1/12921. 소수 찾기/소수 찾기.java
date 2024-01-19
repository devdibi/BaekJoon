class Solution {
    public int solution(int n) {
        int cnt = 0;
        
        for(int i = 2; i <= n; i++){
            if(check(i)) cnt++;
        }
        return cnt;
    }
    public boolean check(int n){
        int cnt = 0;
        int sqrt = (int)Math.sqrt(n);
        
        for(int i = 1; i <= sqrt; i++){
            if(n % i == 0){
                cnt++;
                
                if(i != n / i){
                    cnt++;
                }
            }
            if(cnt > 2) return false;
        }
        return true;
            
    }
}