import java.util.*;

class Solution {
    public class Word implements Comparable<Word> {
        String w;
        String h;
        int n;
        
        public Word(String w, String h, int n){
            this.w = w;
            this.h = h;
            this.n = n;
        }
        
        public int compareTo(Word w){
            if(this.h.equals(w.h)){
                return Integer.compare(this.n, w.n);    
            }
            return this.h.compareTo(w.h);
        }
        
    }
    public String[] solution(String[] files) {
        // HEAD, NUMBER, TAIL 구분
        // HEAD : 앞에서부터 숫자가 나오기 전까지의 문자
        // NUMBER : 앞에서부터 가장 먼저 입력된 숫자
        // TAIL : 첫 숫자의 이후
        
        List<Word> list = new ArrayList<>();
        
        for(String s : files){
            int status = 0;
            
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            
            for(char c : s.toCharArray()){
                // HEAD
                if(status == 0){
                    if(c < 48 || c > 57){
                        head.append(c);
                        continue;
                    }
                    status = 1;
                }
                // NUMBER
                if(status == 1){
                    if(c >= 48 && c <= 57){
                        number.append(c);
                        continue;
                    }
                }
                break;
            }
            list.add(new Word(s, head.toString().toLowerCase(), Integer.parseInt(number.toString())));
        }
        
        Collections.sort(list);
        
        String[] answer = new String[files.length];
        int idx = 0;
        
        for(Word word : list){
            answer[idx++] = word.w;
        }
        
        return answer;
    }
}