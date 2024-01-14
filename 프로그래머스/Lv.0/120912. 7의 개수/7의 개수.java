class Solution {
    public int solution(int[] array) {
        int cnt = 0;
        for(int i : array){
            while(i > 0){
                if(i % 10 == 7){
                    cnt++;
                }
                i /= 10;
            }
        }
        return cnt;
    }
}