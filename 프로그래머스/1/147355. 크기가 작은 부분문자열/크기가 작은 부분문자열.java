class Solution {
    public int solution(String t, String p) {
        long pNum = Long.parseLong(p);
        int cnt = 0;
        for(int i = 0; i < t.length() - p.length()+1;i++){
            long tNum = Long.parseLong(t.substring(i,i + p.length()));
            
            if(tNum <= pNum) cnt++;
        }
        return cnt;
    }
}