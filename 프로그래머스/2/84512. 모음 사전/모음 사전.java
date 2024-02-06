/*
    풀이
        모음으로 만들 수 있는 문자열에서 문자열 순으로 생성한다. => n이 5이하 => 완전탐색
        문자가 생성될때마다 검사해서 일치하면 인덱스 반환
*/

import java.util.*;

class Solution {
    char[] alp = {'A','E','I','O','U'};
    char[] select = new char[5];
    
    int index = 0; // 문자의 인덱스
    String w;
    
    public int solution(String word) {
        for(int i = 0; i < 5; i++){
            select[0] = alp[i]; // 첫 문자 지정
            if (dfs(1,word)) return index; // 해당 단어의 인덱스 반환
        }
        
        // 문자열을 찾지 못했을 때 -1 반환
        return -1;
    }
    
    public boolean dfs(int cnt, String word){
        // 인덱스 추가
        index++;
        
        // 문자열 일치
        if(str().equals(word)) return true;
        
        // 문자열의 길이가 5일때 비교해서 결과 반환
        if(cnt == 5) return str().equals(word);
        
        for(int i = 0; i < 5; i++){
            select[cnt] = alp[i];
            if (dfs(cnt+1,word)) return true;
            select[cnt] = '\u0000';
        }
        
        return false;
    }
    
    // 현재 상태 문자 생성
    public String str(){
        StringBuilder sb = new StringBuilder();
        
        for(char s : select){
            if(s == '\u0000') break;
            sb.append(s);
        }
        
        return sb.toString();
    }
}