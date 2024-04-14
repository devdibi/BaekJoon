class Solution {
    public int solution(int n) {
        int[] result = new int[n+1];
        int idx = 3;
        
        result[1] = 1; // 세로 1개
        result[2] = 2; // 세로 1개 + 가로 1개
        
        while(idx <= n){
            result[idx] = (result[idx - 1] + result[idx - 2]) % 1_000_000_007;
            idx++;
        }
        
        return result[n];
    }
}