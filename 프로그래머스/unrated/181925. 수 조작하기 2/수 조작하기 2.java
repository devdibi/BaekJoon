class Solution {
    public String solution(int[] numLog) {
        int n = numLog.length;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n-1; i++){
            int temp = numLog[i+1] - numLog[i];
            
            if(temp == 1){
                sb.append("w");
            }else if(temp == -1){
                sb.append("s");
            }else if(temp == 10){
                sb.append("d");
            }else if(temp == -10){
                sb.append("a");
            }
        }
        return sb.toString();
    }
}