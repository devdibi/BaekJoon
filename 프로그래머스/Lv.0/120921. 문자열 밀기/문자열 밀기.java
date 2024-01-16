class Solution {
    public int solution(String A, String B) {
        int n = A.length();
        
        int idx = 0;
        boolean status = true;
        
        while(idx < n){
            int i = 0;
            status = true;
            for(int j = 0; j < n; j++){
                if(A.charAt(i) == B.charAt((idx + i) % n)){
                    i++;
                    continue;
                }
                status = false;
            }
            if(status){
                return idx;
            }else{
                idx++;
            }
        }
        return -1;
        
    }
}