class Solution {
    public int solution(int[] sides) {
        int sum = sides[0] + sides[1];
        int max = Math.max(sides[0], sides[1]);
        int cnt = 0;
        for(int i = max; i < sum;i++){
            cnt++;
        }
        
        int min = sum - max;
        // max가 가장긴 변
        for(int i = 0; i < max; i++){
            if(i + min > max){
                cnt++;
            }
        }
        
        return cnt;
    }
}