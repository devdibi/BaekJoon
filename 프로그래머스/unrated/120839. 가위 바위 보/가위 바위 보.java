
class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        char[] rspList = rsp.toCharArray();
        
        for(char c : rspList){
            if(c == '0'){
                sb.append(5);
            }else if(c == '2'){
                sb.append(0);
            }else if(c == '5'){
                sb.append(2);
            }
        }
                     
        return sb.toString();
    }
}