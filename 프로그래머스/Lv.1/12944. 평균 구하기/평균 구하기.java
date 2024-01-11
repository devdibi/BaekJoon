class Solution {
    public double solution(int[] arr) {
        int sum = 0;
        int cnt = 0;
        
        for(int i : arr){
            sum+=i;
            cnt++;
        }
        
        return (double)sum / (double) cnt;
    }
}