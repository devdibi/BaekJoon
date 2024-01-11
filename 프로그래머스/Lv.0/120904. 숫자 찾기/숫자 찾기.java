class Solution {
    public int solution(int num, int k) {
        int idx = 1;
        for(int c : String.valueOf(num).toCharArray()){
            if((c - 48) == k){
                return idx;
            }
            idx++;
        }
        
        return -1;
    }
}