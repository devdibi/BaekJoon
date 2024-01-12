class Solution {
    public long solution(long n) {
        double num = Math.sqrt(n);
        if(num == (long)num){
            return (long) ((num+1) * (num+1));
        }else{
            return -1;
        }
    }
}