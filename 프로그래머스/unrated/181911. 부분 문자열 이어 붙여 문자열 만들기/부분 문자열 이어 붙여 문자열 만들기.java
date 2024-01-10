class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        for(String s : my_strings){
            sb.append(s.substring(parts[idx][0], parts[idx++][1]+1));
        }
        
        return sb.toString();
    }
}