class Solution {
    public int solution(int[] common) {
        if((common[2] - common[1]) == (common[1] - common[0])){
            int d = common[1] - common[0];
            return common[common.length - 1] + d;
        }
        
        int r = common[1] / common[0];
        
        return common[common.length - 1]*r;
        
    }
}