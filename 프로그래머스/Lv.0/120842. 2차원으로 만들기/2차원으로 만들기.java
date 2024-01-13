class Solution {
    public int[][] solution(int[] num_list, int n) {
        int len = num_list.length;
        int[][] result = new int[len/n][n];
        
        for(int i = 0; i < len/n; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = num_list[n*i+j];
            }
        }
        return result;
    }
}