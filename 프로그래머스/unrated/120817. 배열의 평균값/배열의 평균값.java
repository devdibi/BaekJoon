class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        
        int sum = 0;
        int n = numbers.length;
        
        for(int i : numbers) sum += i;
        
        answer = (double)sum / (double)n;
        
        return answer;
    }
}