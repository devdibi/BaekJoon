class Solution {
    public int solution(int chicken) {
        int cnt = 0;

        while(chicken >= 10){
            int a = chicken % 10;
            cnt += (chicken /= 10);
            chicken += a;
        }
        
        
        return cnt;
    }
}