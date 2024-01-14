class Solution {
    public int solution(String[] strArr) {
        int max = -1;
        
        for(String str : strArr){
            max = Math.max(max, str.length());
        }
        
        int[] cnt = new int[max+1];
        
        for(String s : strArr){
            cnt[s.length()]++;
        }
        
        max = -1;
        
        for(int c : cnt){
            max = Math.max(max, c);
        }
        
        return max;
    }
}