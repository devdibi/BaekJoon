import java.util.*;
class Solution {
    Set<String> set = new HashSet<>();
    
    public int[] solution(int n, String[] words) {
        set.add(words[0]); // 첫 단어 
        
        int idx = 1; // 다음 단어
        for(String s : words){
            if(idx < words.length){
                // System.out.println(idx + " " + s);
                
                // 중복 체크
                if(!set.contains(words[idx])){
                    set.add(words[idx]); // 추가
                }else{
                    return new int[]{idx % n + 1, (idx/n)+1}; // 반환
                }
            
                if(!check(s, words[idx])){
                    return new int[]{idx % n +1, (idx/n)+1};
                }
                
                idx++;
            }
        }
        
        return new int[]{0,0};
    }
    // 끝 문자와 시작 문자의 일치 여부 확인
    public boolean check(String a, String b){   
        if(b.startsWith(String.valueOf(a.charAt(a.length()-1)))) return true;
        return false;
    }
}