class Solution {
    public int[] solution(String my_string) {
        int[] result = new int[52];
        
        for(char c : my_string.toCharArray()){
            if(c < 97){
                result[c - 65]++;    
            }else{
                result[c - 97 + 26]++;
            }
            
        }
        return result;
    }
}