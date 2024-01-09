class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // 무료 음료수 개수
        answer += 12_000 * n;
        
        k -= n / 10;
        
        if(k > 0){
            answer += k * 2000;
        }
        
        return answer;
    }
}