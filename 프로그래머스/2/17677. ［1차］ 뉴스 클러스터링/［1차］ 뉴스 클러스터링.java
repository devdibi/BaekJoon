/*
    풀이
        n(AnB) / n(AuB) 를 구하고 65536을 곱하고 남은 정수값을 반환
        1. 문자열을 두글자 단위로 분할한다.
            - 두글자씩 문자열의 배열을 생성
            - 문자열 정리 : 특수문자와 숫자는 제외한다, 대문자와 소문자 차이 무시
        2. n(AnB) 계산
            - 중복되는 값도 독립된 하나의 객체로 생각한다.(Map을 활용해서 비교) return List.size();
        3. n(AuB) 계산
            - n(AnB)를 제외한 나머지 값을 더한다 return List.size();
*/
import java.util.*;

class Solution {
    public static final double NUM = 65536;
    public int solution(String str1, String str2) {
        // 문자열 분할 및 처리
        String[] s1 = divide(str1);
        String[] s2 = divide(str2);
        
        // 공집합이면 종료
        if(s1.length == 0 && s2.length == 0) return (int)NUM;
        
        // 교집합
        int inter = 0;
        
        for(int i = 0; i < s1.length; i++){
            String s = s1[i];
            for(int j = 0; j < s2.length; j++){
                if(s.equals(s2[j])){
                    s2[j] = ".";
                    inter++;
                    break;
                }
            }
        }
        
        // 합집합(s1 + 교집합을 제외한 s2)
        int out = s1.length;
        
        // 교집합을 제외한 s2 개수 계산
        for(String s : s2) if(!s.equals(".")) out++;
        
        return result(inter, out);
    }
    
    // 유사도와 65536의 곱 반환
    public int result(int inter, int out){
        return (int) (((double) inter / (double) out) * 65536);
    }
    
    // 집합 생성
    public String[] divide(String str){
        // 대소문자 구분 제거
        str = str.toLowerCase();
        
        // 계속 추가를 위해 StringBuilder를 활용
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length()-1; i++){
            // 두자리 문자열 추가 및 구분자 추가(공백을 포함한 특수문자도 포함하므로 대문자 문자열을 활용)
            sb.append(str.charAt(i)).append(str.charAt(i+1)).append("A");
        }
        
        return process(sb.toString().split("A"));
    }
    
    // 안되는 문자열 제거
    public String[] process(String[] str){
        StringBuilder sb = new StringBuilder();
        
        for(String s : str){
            // 범위에 어긋나는 문자 하나 활용
            char c = 'A';
            for(int i = 0; i < s.length(); i++){
                c = s.charAt(i);
                if(c > 96 && c < 123) continue;
                
                // 범위에 어긋나는 경우
                c = 'A';
                break;
            }
            
            if(c != 'A'){
                sb.append(s).append(" ");          
            }
        }
        // 공백으로 자르기
        return sb.toString().split(" ");
    } 
}