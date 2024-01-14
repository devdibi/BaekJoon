class Solution {
    public int solution(String[] strArr) {
        int[] cnt = new int[31];
        
        for(String s : strArr){
            cnt[s.length()]++;
        }
        
        int max = -1;
        
        for(int c : cnt){
            max = Math.max(max, c);
        }
        
        return max;
    }
}