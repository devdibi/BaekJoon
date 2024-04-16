class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        
        for(int i  = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
        
        // 행
        for(int i = 1; i < land.length; i++){
            // dp 열
            for(int j = 0; j < 4; j++){
                // land 열
                for(int k = 0; k < 4; k++){
                    if(k == j) continue;
                    if(dp[i][j] < land[i][j] + dp[i-1][k]){
                        dp[i][j] = land[i][j] + dp[i-1][k];
                    }
                }        
            }
        }
        
        int answer = -1;
        for(int i = 0; i < 4; i++){
            answer = Math.max(answer, dp[land.length-1][i]);
        }
        
        return answer;
    }
}