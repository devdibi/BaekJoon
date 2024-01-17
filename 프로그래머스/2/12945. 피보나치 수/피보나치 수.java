class Solution {
    int[] fib = new int[100_001];
    public int solution(int n) {
        fib(n);
        return fib[n-1];
    }
    public void fib(int n){
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i <= n; i++){
            fib[i] = (fib[i-2] + fib[i-1]) % 1234567;
        }
    }
}