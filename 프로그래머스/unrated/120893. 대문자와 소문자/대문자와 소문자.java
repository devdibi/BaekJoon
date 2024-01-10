class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : my_string.toCharArray()){
            if(c >= 'a'){
                sb.append(String.valueOf(c).toUpperCase());
            }else{
                sb.append(String.valueOf(c).toLowerCase());
            }
        }
        
        return sb.toString();
    }
}