class Solution {
    public int solution(int n) {
        // n 이하의 모든 수를 연속적으로 더하고 같으면 추가, 크면 continue
        int cnt = 0;
        int sum = 0;
        int num = 1;
        
        for(int i = 1; i <= n; i++){
            sum = 0;
            num = i;
            while(sum < n){
                sum += (num++);  
                if(sum == n) cnt++;
            }
        }
        
        return cnt;
    }
}