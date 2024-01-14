class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(char c : code.toCharArray()){
            if(idx % q == r){
                sb.append(c);
            }
            idx++;
        }
        return sb.toString();
    }
}