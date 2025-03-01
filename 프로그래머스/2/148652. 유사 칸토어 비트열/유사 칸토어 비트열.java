class Solution {
    public int solution(int n, long l, long r) {
        return (int)(cal(n, r) - cal(n, l - 1));
    }
    
    private long cal(int n, long m) {
        if (m <= 0) return 0;
        if (n == 0) return 1;
        
        long len = (long)Math.pow(5, n - 1);
        long block = (m - 1) / len + 1;
        long etc = (m - 1) % len + 1;
        
        long result = 0;
        if (block > 1) {
            result = (block - 1) * cal(n - 1, len);
            
            if (block > 3) {
                result -= cal(n - 1, len);
            }
        }
        
        if (block != 3) {
            result += cal(n - 1, etc);
        }
        
        return result;
    }
}