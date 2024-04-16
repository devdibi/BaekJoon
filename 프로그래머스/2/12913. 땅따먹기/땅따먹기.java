class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4]; // DP 저장 배열
        
        for(int i  = 0; i < 4; i++){
            dp[0][i] = land[0][i]; // 맨 처음 행 저장
        }
        
        // 행
        for(int i = 1; i < land.length; i++){
            // dp 열
            for(int j = 0; j < 4; j++){
                // land 열
                for(int k = 0; k < 4; k++){
                    if(k == j) continue; // 같은 열 선택 불가
                    
                    // 해당 열을 선택했을 경우 가장 큰 값을 갖는 경우 계산
                    if(dp[i][j] < land[i][j] + dp[i-1][k]){
                        dp[i][j] = land[i][j] + dp[i-1][k];
                    }
                }        
            }
        }
        
        int answer = -1;
        for(int i = 0; i < 4; i++){
            answer = Math.max(answer, dp[land.length-1][i]); // 모두 더한 값에서 최대값 판별
        }
        
        return answer;
    }
}