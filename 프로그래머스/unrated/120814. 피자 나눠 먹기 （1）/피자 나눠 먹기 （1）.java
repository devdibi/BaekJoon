class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 피자는 무조건 7의 배수
        
        answer += n/7;
        
        if(n % 7 != 0){
            answer++;
        }
        
        return answer;
    }
}