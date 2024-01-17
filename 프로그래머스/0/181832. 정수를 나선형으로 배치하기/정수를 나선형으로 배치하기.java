class Solution {
    int[] r = {0,1,0,-1};
    int[] c = {1,0,-1,0};
    public int[][] solution(int n) {
        int idx = 1;
        int d = 0;
        int[][] result = new int[n][n];
        
        int rIdx = 0, cIdx = 0;
        while(idx <= n*n){
            result[rIdx][cIdx] = idx++;
            
            if(rIdx + r[d] >= n || cIdx + c[d] >= n || rIdx + r[d] < 0 || cIdx + c[d] < 0 || result[rIdx + r[d]][cIdx + c[d]] != 0) {
                d++;
                d %= 4;
            }
            rIdx += r[d];
            cIdx += c[d];
        }
        return result;
    }
}