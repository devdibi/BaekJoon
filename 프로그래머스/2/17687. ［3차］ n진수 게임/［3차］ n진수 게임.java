/*
    풀이
        n진법에 따라 0부터 증가하는 숫자를 하나의 문자열로 만든다.(t,m,p를 활용해 어디까지 구할지 계산)
        이 문자열을 분할하고 계산식에 맞게 구현
*/

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        int max = p;
        // 최소 자리수 구하기
        for(int i = 0; i < t; i++) max += i * m;
        
        // n진수의 값 생성
        StringBuilder sb = new StringBuilder();
        
        int num = 0;
        
        while(sb.length() < max){
            // n 진수로 변환
            sb.append(convert(num, n));
            num++;
        }
        
        String temp = sb.toString();
        
        sb = new StringBuilder();
        
        int idx = p-1;
        
        // 원하는 위치의 값 구하기
        for(int i = 0; i < t; i++){
            sb.append(temp.charAt(idx + i * m));
        }
        
        return sb.toString();
    }
    
    // 결과값 반환
    public String convert(int num, int n){
        return Integer.toString(num,n).toUpperCase();
    }
    
    
}