class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        
        c--;
        while(c < my_string.length()){
            sb.append(my_string.charAt(c));
            c += m;
        }
        return sb.toString();
    }
}