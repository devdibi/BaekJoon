class Solution {
    public int solution(String number) {
        int result = 0;
        for(int c : number.toCharArray()){
            result += c - 48;
        }
        return result % 9;
    }
}