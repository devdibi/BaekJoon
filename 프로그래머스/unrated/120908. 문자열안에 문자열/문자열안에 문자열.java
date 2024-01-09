class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int cnt = 0;
        
        for(int i = 0; i < str1.length() - str2.length() + 1; i++){
            cnt = 0;
            int idx = i;
            for(int j = 0; j < str2.length(); j++){
                if(str1.charAt(idx++) == str2.charAt(j)){
                    cnt++;
                }else{
                    break;
                }
            }
            
            if(cnt == str2.length()){
                return 1;
            }
        }
        
        return 2;
    }
}