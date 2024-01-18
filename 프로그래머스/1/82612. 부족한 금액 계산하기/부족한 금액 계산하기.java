class Solution {
    public long solution(int price, int money, int count) {
        long cnt = 0;
        for(int i = 1; i <= count; i++) cnt += i;
        long result = money - price * cnt;
        
        return result < 0 ? Math.abs(result) : 0;
    }
}
