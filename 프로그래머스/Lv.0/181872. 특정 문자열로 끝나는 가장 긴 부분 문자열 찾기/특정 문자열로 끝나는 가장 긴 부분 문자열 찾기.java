class Solution {
    public String solution(String myString, String pat) {
        // 탐색을 뒤에서 시작
        int patLen = pat.length() -1;
        int strLen = myString.length() -1 - patLen;
        boolean status = false;
        
        for(int i = strLen; i >= 0; i--){
            for(int j = patLen; j >= 0; j--){
                if(myString.charAt(i+j) == pat.charAt(j)){
                    status = true;
                    continue;
                }
                status = false;
            }
            if(status){
                return myString.substring(0,i + patLen + 1);
            }
        }
        return pat;
    }
}