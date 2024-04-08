class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] result = new int[len];
        
        for(int i = 0; i < len; i++){
            int time = 0;
            for(int j = i+1; j < len; j++){
                time++;
                if(prices[i] > prices[j]) break;
            }
            result[i] = time;
        }
        return result;
    }
}