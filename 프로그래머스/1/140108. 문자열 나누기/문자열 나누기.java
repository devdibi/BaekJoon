class Solution {
    public int solution(String s) {
        char x = '-';
        int l = 0;
        int r = 0;
        int cnt = 0;
        
        char[] str = s.toCharArray();
        
        for(char c : str){
            // 초기 세팅
            if(x == '-'){
                x = c;
                l = 1;
                continue;
            }
            
            if(x == c){
                l++;
            }else{
                r++;
            }
            if(l == r){
                x = '-';
                l = 0;
                r = 0;
                cnt++;
            }
        }
        
        if(x != '-'){
            cnt++;
        }
        return cnt;
    }
}