class Solution {
    public int solution(int[] box, int n) {
        int result = 1;
        for(int i : box){
            result *= i / n;
        }
        return result;
    }
}