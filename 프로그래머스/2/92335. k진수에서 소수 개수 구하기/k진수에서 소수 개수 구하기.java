/*
    풀이
        양의 정수 n을 k 진수로 변환
        k진수 내에서 0을 기준으로 숫자를 분할한다.
        그 숫자에서 10진수로 가정했을 때의 소수를 찾는다.
        (같은 수도 다른 수로 취급, 숫자의 중간에 0이 포함되서는 안된다.)
        규칙으로 정한 형태의 숫자가 몇개인지 파악한다.
        
*/
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        return convert(n,k);
    }
    
    
    public int convert(int n, int k){
        // n을 k진수로 나눈 나머지를 하나씩 Stack에 추가한다.
        Stack<String> stack = new Stack<>();
        
        // k진수 문자열 stack에 추가
        while(n != 0){
            stack.push(String.valueOf(n % k));
            n /= k;
        }
        
        // stack에서 문자열로변환
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        
        int count = 0;
        
        for(String s : sb.toString().split("0")){
            if(s.equals("")) continue;
            
            // 문자열정수 변환
            long temp = Long.parseLong(s);
            
            // 2보다 작은 값은 소수가 될수 없음
            if(temp < 2) {
                continue;
            }
            
            // 2인 경우 무조건 소수
            if(temp == 2) {
                count++;
                continue;
            }
            
            // 제곱근 미만까지 나누는 방식으로 계산
            long end = (long)Math.sqrt(temp);
            
            // 짝수를 모두 제외하기 위해 2부터 시작
            long num = 2;
            
            boolean status = true;
            
            while(num <= end){
                // 나머지가 0이되면 소수가 아님
                if(temp % num == 0) {
                    status = false;
                    break;
                }
                num++;
            }
            
            // 나머지가 0이 나오지 않았으면 소수
            if(status) count++;
        }
        return count;
    }
    
}