class Solution {
    public int solution(int n) {
        // n의 다음 큰 숫자는 n보다 큰 자연수
        // n의 다음 큰 숫자는 2진수로 변환했을 때 1의 개수 동일
        // n의 다음 큰 숫자는 조건 1,2를 만족하는 가장 작은 수
        
        String nb = Integer.toBinaryString(n);
        nb = nb.replace("0","");
        
        int num = n+1;
        while(true){
            if(check(num, nb)) return num;
            num++;
        }
    }
    public boolean check(int num, String str){
        // 0을 제거한 길이가 같으면 됨
        String big = Integer.toBinaryString(num);
        big = big.replace("0","");
        
        if(big.length() == str.length()) return true;
        return false;
    }
}