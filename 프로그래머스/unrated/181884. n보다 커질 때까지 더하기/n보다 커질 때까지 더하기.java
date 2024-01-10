class Solution {
    public int solution(int[] numbers, int n) {
        int result = 0;
        for(int i : numbers){
            result += i;
            if(result > n){
                return result;
            }
        }
        return result;
    }
}