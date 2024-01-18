import java.util.*;

class Solution {
    public class Word implements Comparable<Word>{
        String s;
        char c;
        
        public Word(String s, char c){
            this.s = s;
            this.c = c;
        }
        
        public int compareTo(Word w){
            // 만약 문자(char)가 같다면 문자열을 비교
            if (Character.compare(this.c, w.c) == 0) {
                return this.s.compareTo(w.s);
            } else {
                // 문자(char)가 다르다면 비교 결과 반환
                return Character.compare(this.c, w.c);
            }
        }
        
        public String toString(){
            return s + " " + c ;
        }
    }
    public String[] solution(String[] strings, int n) {
        Word[] words = new Word[strings.length];
        int idx = 0;
        for(String s : strings){
            words[idx++] = new Word(s, s.charAt(n));
        }
        
        Arrays.sort(words);
        
        idx = 0;
        
        for(Word w : words){
            strings[idx++] = w.s;
        }
        return strings;
    }
}