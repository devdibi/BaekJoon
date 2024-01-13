class Solution {
    public int solution(int i, int j, int k) {
        int cnt = 0;
        
        while(i <= j){
            for(char c : String.valueOf(i).toCharArray()){
                if(k == c-48) cnt++;
            }
            i++;
        }
        return cnt;
    }
}