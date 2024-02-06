import java.util.*;

class Solution {
    List<String> index = new ArrayList<>();
    
    public int[] solution(String msg) {
        // 최초 사전
        for(int i = 0; i < 26; i++){
            index.add(String.valueOf((char)('A' + i)));
        }
        int left = 0;
        int right = 0;
        
        // 결과 저장 리스트
        List<Integer> list = new ArrayList<>();
        
        while(true){
            // 입력
            String input = msg.substring(left, right);
            
            // 다음 글자
            String next = msg.substring(right,right+1);
            
            // w+c
            String piece = input+next;
            
            
            // w+c가 포함된 경우
            if(index.contains(piece)){
                right++;
            }else{
                // 포함되지 않은 경우(사전 추가)
                index.add(piece);
                
                // w에 해당하는 index list에 추가
                list.add(index.indexOf(input) + 1);
                
                left = right;
                right++;
            }
            // 마지막
            if(right == msg.length()){
                list.add(index.indexOf(msg.substring(left,right)) + 1);
                break;
            }
        }
        
        int[] result = new int[list.size()];
        int idx = 0;
        for(int i : list){
            result[idx++] = i;
        }
        
        return result;
    }
}