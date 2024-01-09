class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        for(char c : my_string.toCharArray()){
            if((int)c > 48 && (int)c < 58) answer += Character.getNumericValue(c);
        }
        
        return answer;
        
    }
}

