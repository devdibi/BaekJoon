class Solution {
    
    public String solution(String s, int n) {
        // char에서 'A': 65 - 'Z':90 , 'a':97 - 'z':122
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int c : str){
            if(c == ' '){
                sb.append(" ");
            }
            else if(c < 91){
                sb.append((char)((((int) c - 65 + n) % 26) + 65));
            }else if(c > 96){
                sb.append((char)((((int) c - 97 + n) % 26) + 97));
            }
        }
        
        return sb.toString();
    }
}